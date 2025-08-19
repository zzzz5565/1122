package com.huitong.common.utils.security;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;
import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA加密解密
 **/
@Component
public class RsaUtils
{
    //后端持有（私钥）密钥对：前端公钥加密，后端私钥解密
    public static final String publicKeyStr = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCH9rZTKdJduYSemxSRSCSf2NSKGHlS0m25O/Va9f4/igak4q1ORZWjs3Ennll/k1U2LrzyHCxaIK9XtI2YKXk3tFe2urMnN71clgkuXK0wt04Um/Ln6Av5TQ1/k16r1ZY3Ti0rdwokRSfjyQ5TVuQf1DXfeykzfrwLJZgsdGJS9wIDAQAB";
    public static final String privateKeyStr = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIf2tlMp0l25hJ6bFJFIJJ/Y1IoYeVLSbbk79Vr1/j+KBqTirU5FlaOzcSeeWX+TVTYuvPIcLFogr1e0jZgpeTe0V7a6syc3vVyWCS5crTC3ThSb8ufoC/lNDX+TXqvVljdOLSt3CiRFJ+PJDlNW5B/UNd97KTN+vAslmCx0YlL3AgMBAAECgYAhAL3ZCfnKTlHmvfYMHdrmAhf1PWOVuwZvRCKWZcfFXJeoRm2S5kkgZ1o8J6/Jy9WPRWEP087gQbbOL0F/gfGuOv5CXjbK/7YOGY37j2A1H/6+m7KUqYFyXDQ5wbZHg4XLmbtZ2xP1D/prxlJa6bwAn34Xh0qsdDhrimL1lPTs4QJBAOkzOqMI7fA5Co4vYq/MVcm4WccNpxXOmQ1nallW30Vw8NeMmRtN8JfBMZtC5SNKPr/pY31VW1zjCBT+/jWb+0MCQQCVQcBRMXIkaw7mHpbetF4L+D0T1JNXpSSNC160yKHbTxDJS5waf8GM1pNE7wHdfcahnKQSY/kbhn5J2PjRwXw9AkEAkCLM3FY5kt/+yTE6owP+Bkc+nkyu+EiQyvsffYa3S5lqEyBgxcKfsXyEp71qGSzbqgycJKxsYvYkWa3d+86kNwJAWvmKyXKECiKfIDCA8RmrQUx7nfyyGnf0QWwuu66WyV/18Vv+uEAqrzeS6C9uSZ0CVzts3jDFg7uEemqfrupqWQJBAJ9Si9OEeSu8RWVSi5v7mJE7y/6lvPRQPvHT1wLYiUDrAoX3mZiGvg76Ae1rTyFtFNbAFh1W5DFb9KGwZfkO+us=";

    //前端持有（私钥）密钥对：后端公钥加密，前端私钥解密
    private static final String responsePublicKeyStr="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCtgN7ecQK8KlBqNEt3zoGQZhz4IKnCDmSMEhf4+ckaCa8/bHICc6nLI52ree1Wke7WNLwtAotsiXzDCoDGPfoKQjvlxG1VqugaaCMWvYkgGjPG7KTTvnoCd7qNCmorgpifIofpiZGC+oRw7tyXdlWSxBycAICJre37CKkwZm42SwIDAQAB";
    private static final String responsePrivateKeyStr="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK2A3t5xArwqUGo0S3fOgZBmHPggqcIOZIwSF/j5yRoJrz9scgJzqcsjnat57VaR7tY0vC0Ci2yJfMMKgMY9+gpCO+XEbVWq6BpoIxa9iSAaM8bspNO+egJ3uo0KaiuCmJ8ih+mJkYL6hHDu3Jd2VZLEHJwAgImt7fsIqTBmbjZLAgMBAAECgYBhGrohVrCILUp6VjBSqkH7Vhsqh+ValYGSn2HJV8tEhl0Nqx0X4DIMXi+VVBUQGXbJbhRPQJhVs5Ee+9bcnL0+Z4IR9gKJ5rTPaRqBMV/ryoVe4gPm27SkozZd32f7RxKWRg5XoUhDLB/eL+bYkIxGGw+C+Cc8rK3wZ7+wk7t8CQJBAPhW5N8WgkJLDiXIEp/4kanKsn0oiDQvY2msYa/EgazluusFPDL3bJm4iyWeVEJUomcukSf+DK2rRkyZD1Y7Rs8CQQCy2wFwj+lZs0pnrq1Krd54OChsCD3HiGh9i54lo5mF+vApRJ4q4+Ys2RYtJ3NJ+BzABuyJRv8ZU5iBPUbuUffFAkEAlMh6lq2FnPIap8gWYIErw+4Mwa9m6tz5UnZUkFnK1ytLsUKRrndOOUq3EvKoyJSsN+VOUgeC0QmsNHf/GEqrQQJAcZTZFjWeGCPe5Xctf5ZpCGmJagnVyegbi1bl6Ls7XLVeXKbB1zUBUIvQJH7AHUJeZ6g+AHPAvsGywKg8ak5NjQJANW+m6wy/pkEGE7wzCRmk49MJlH7rkxA5UnzSSh0H1mGVTUtkG5ggzaPiIh4XPhDD9lESV0yS5km0UKYjcODQ3Q==";

    public static String getResponsePrivateKeyStr() {
        return responsePrivateKeyStr;
    }
    public static String getResponsePublicKeyStr() {
        return responsePublicKeyStr;
    }

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * 公钥加密
     */
    public static String encryptByPublicKey(String publicKeyString, String text) throws Exception
    {
        X509EncodedKeySpec x509EncodedKeySpec2 = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec2);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(result);
    }

    /**
     * 公钥加密-分段加密
     */
    public static String encrypt(String data,PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] dataBytes = data.getBytes();
        int inputLen = dataBytes.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache=new byte[256];;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(dataBytes, offset, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] result = out.toByteArray();
        out.close();
        return Base64.encodeBase64String(result);
    }

    /**
     * 私钥解密
     */
    public static String decryptByPrivateKey(String privateKeyString, String text) throws Exception
    {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec5 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec5);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(Base64.decodeBase64(text));
        return new String(result);
    }

    /**
     * 私钥解密-分段解密
     */
    public static String decrypt(String data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] dataBytes = Base64.decodeBase64(data);
        int inputLen = dataBytes.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache=new byte[256];;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offset > 0) {
            if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(dataBytes, offset, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        // 解密后的内容
        String decryptBody = new String(decryptedData, "UTF-8");
        return decryptBody;
    }

    /**
     * 随机生成密钥对
     */
    public Map keyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        String publicKeyString = Base64.encodeBase64String(rsaPublicKey.getEncoded());
        String privateKeyString = Base64.encodeBase64String(rsaPrivateKey.getEncoded());
        Map map = new HashMap();
        map.put("publicKeyString",publicKeyString);
        map.put("privateKeyString",privateKeyString);
        return map;
    }

    /**
     * 获取公钥
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }

    /**
     * 获取私钥
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodedKey = Base64.decodeBase64(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        return keyFactory.generatePrivate(keySpec);
    }

    //TODO 签名、验签



    public static void main(String[] args) throws Exception {
        RsaUtils rsaUtils = new RsaUtils();
        //随机生成加密键值对
        Map pairMap = rsaUtils.keyPair();
        System.out.println(pairMap);

        String a = rsaUtils.encryptByPublicKey(publicKeyStr,"traffic_cloud");//这个是数据库用户名
        String b = rsaUtils.encryptByPublicKey(publicKeyStr,"YTJJhuitong2023**");//这个是数据库密码
        System.out.println(a);//加密后的用户名
        System.out.println(b);//加密后的密码


        String a1 = rsaUtils.decryptByPrivateKey(privateKeyStr,a);//解密
        String b1 = rsaUtils.decryptByPrivateKey(privateKeyStr,b);//解密
        System.out.println(a1);
        System.out.println(b1);
    }
}
