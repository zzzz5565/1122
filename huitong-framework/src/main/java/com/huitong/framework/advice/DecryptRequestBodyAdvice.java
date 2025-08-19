package com.huitong.framework.advice;

import com.alibaba.fastjson.JSONObject;
import com.huitong.common.annotation.Decrypt;
import com.huitong.common.utils.security.RsaUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import java.io.*;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 解密带有注解@Decrypt的@RequestBody参数
 */
@ControllerAdvice
public class DecryptRequestBodyAdvice implements RequestBodyAdvice {

    @Value("${shiro.encryption}")
    private Boolean encryption;

    private boolean encrypt;

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        boolean ifDecrypt = methodParameter.getMethod().isAnnotationPresent(Decrypt.class);
        if (ifDecrypt && encryption) {
            encrypt = true;
        }else{
            encrypt = false;
        }
        return encrypt;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
                                           Class<? extends HttpMessageConverter<?>> converterType) {
        if (encrypt) {
                try {
                    String content = "";
                    content = new BufferedReader(new InputStreamReader(inputMessage.getBody()))
                            .lines().collect(Collectors.joining(System.lineSeparator()));
                    String decryptBody = RsaUtils.decrypt(content,RsaUtils.getPrivateKey(RsaUtils.privateKeyStr));//分段解密
                    decryptBody= URLDecoder.decode(decryptBody,"UTF-8");
                    if((targetType==String.class||targetType==Long.class||targetType==Integer.class
                            ||targetType==Boolean.class ||targetType==Float.class||targetType==Double.class
                            ||targetType==Boolean.class) &&decryptBody!=null){
                        Map param = JSONObject.parseObject(decryptBody, Map.class);
                        decryptBody = (String)param.get(param.keySet().iterator().next());
                    }
                    String finalDecryptBody = decryptBody;
                    HttpInputMessage newInputMessage = new HttpInputMessage() {
                        @Override
                        public InputStream getBody() {
                            return new ByteArrayInputStream(finalDecryptBody.getBytes());
                        }
                        @Override
                        public HttpHeaders getHeaders() {
                            return inputMessage.getHeaders();
                        }
                    };
                    return newInputMessage;
                }catch (Exception e){
                    e.printStackTrace();
                    return inputMessage;
                }
        }
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
                                Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }
}