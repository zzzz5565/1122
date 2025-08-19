package com.huitong.framework.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.huitong.common.annotation.Encrypt;
import com.huitong.common.utils.security.RsaUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import java.net.URLEncoder;

@ControllerAdvice
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Value("${shiro.encryption}")
    private Boolean encryption;

    private boolean encrypt;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        boolean ifEncryp = returnType.getMethod().isAnnotationPresent(Encrypt.class);
        if (ifEncryp && encryption) {
            encrypt = true;
        }else{
            encrypt = false;
        }
        return encrypt;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (encrypt) {
            try{
                //日期处理
                String content = JSON.toJSONStringWithDateFormat(body, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
                //空格处理
                String text = URLEncoder.encode(content,"UTF-8").replaceAll("\\+", "%20");
                String result = RsaUtils.encrypt(text,RsaUtils.getPublicKey(RsaUtils.getResponsePublicKeyStr()));
                return result;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return body;
    }
}