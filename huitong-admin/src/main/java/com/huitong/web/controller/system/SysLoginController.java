package com.huitong.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huitong.common.annotation.Log;
import com.huitong.common.enums.BusinessType;
import com.huitong.common.utils.security.RsaUtils;
import com.huitong.framework.web.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huitong.common.core.controller.BaseController;
import com.huitong.common.core.domain.AjaxResult;
import com.huitong.common.core.text.Convert;
import com.huitong.common.utils.ServletUtils;
import com.huitong.common.utils.StringUtils;
import com.huitong.framework.web.service.ConfigService;

import java.net.URLDecoder;

/**
 * 登录验证
 *
 *
 */
@Controller
public class SysLoginController extends BaseController
{

    @Autowired
    private PermissionService permissionService;

    @Value("${shiro.encryption}")
    private Boolean encryption;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap mmap)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        // 是否开启记住我
        mmap.put("isRemembered", false);
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password)
    {
        try
        {
            if(encryption==true) {
                username= URLDecoder.decode(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,username), "utf-8").replaceAll("\"","");
                password=URLDecoder.decode(RsaUtils.decryptByPrivateKey(RsaUtils.privateKeyStr,password), "utf-8").replaceAll("\"","");
            }
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, false);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            return success();
        }
        catch (Exception e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/yunPlatform")
    @Log(title = "烟台交警智慧交通云平台访问", businessType = BusinessType.OTHER)
    public String yunLogin()
    {
        try{
            UsernamePasswordToken token = new UsernamePasswordToken("@dmin", "HT@dmin2022", false);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            return "redirect:/index";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "error/unauth";
    }

    //公钥密钥
    @PostMapping("/publicKey")
    @ResponseBody
    public String publicKey() {
        return RsaUtils.publicKeyStr;
    }

    //返回加密//前端私钥
    @PostMapping("/responseprivatekey")
    @ResponseBody
    public String responseprivatekey() {
        return RsaUtils.getResponsePrivateKeyStr();
    }

    //是否加密
    @PostMapping("/isEncryption")
    @ResponseBody
    public Boolean isEncryption() {
        return permissionService.isEncryption();
    }
}
