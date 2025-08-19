package com.huitong.common.annotation;

import java.lang.annotation.*;

/**
 * DecryptRequestBodyAdvice使用 前端加密后端解密
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Decrypt {
}
