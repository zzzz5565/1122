package com.huitong.common.annotation;

import java.lang.annotation.*;

/**
 * EncryptResponseBodyAdvice使用 后端加密前端解密
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Encrypt{

}