package com.huitong.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.huitong.common.utils.security.RsaUtils;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapToEntity {

    public static <T> T StringToEntity(String content, Class<T> clazz,Boolean encryption) throws Exception{
        Map map = new HashMap();
        if(encryption==true) {
            //RSA解码json字符串
            content = RsaUtils.decrypt(content,RsaUtils.getPrivateKey(RsaUtils.privateKeyStr));
        }
        if (getJSONType(content)) {
            List list = JSONObject.parseObject(content, List.class);
            for (Object object : list) {
                map.put(((Map) (object)).get("name"), ((Map) (object)).get("value"));
            }
        } else {
            String[] arry = content.substring(1, content.length() - 1).split("&");
            for (String str : arry) {
                if (StringUtils.isNotEmpty(str) && !str.equals("=")) {
                    String[] arry1 = str.split("=");
                    if (arry1.length > 1) {
                        map.put(arry1[0], arry1[1]);
                    } else {
                        map.put(arry1[0], null);
                    }

                }
            }
        }
        return mapToEntity(map, clazz);
    }

    public static <T> T mapToEntity(Map<?, ?> map, Class<T> clazz) {

        // 验证Map和实体类Class对象是否为空
        Assert.notNull(map, "map cannot be null");
        Assert.notNull(clazz, "entity class cannot be null");
        try {
            List<Field> allFields = new ArrayList<>();
            T t = clazz.newInstance();
            Class<?> aClass = clazz;
            do {
                // 利用Java反射获取自身属性以及父类属性
                allFields.addAll(Stream.of(aClass.getDeclaredFields()).collect(Collectors.toList()));
                aClass = aClass.getSuperclass();
                // Object类为超级大类，到了Object类，继承关系已到了顶点，不需要处理了
            } while (!StringUtils.equals(aClass.getTypeName(), Object.class.getTypeName()));
            Method[] methods = clazz.getDeclaredMethods();
            // 对实体类的属性进行遍历
            for (Field field : allFields) {
                // 获取属性名称
                String fieldName = field.getName();
                // 属性对应的实体类名称，这里需要一一对应，否则取不到值
                Object data = map.get(fieldName);
                // 按照Java约定的getter、setter方法命名规范，拼装setter方法名
                String methodName = StringUtils.format("set{}{}", fieldName.substring(0, 1).toUpperCase(), fieldName.substring(1));
                // 获取setter方法的Method对象
                if (methodName.indexOf("set") > -1) {
                    if(!methodName.contains("setSerialVersion")){
                        Method method = clazz.getMethod(methodName, field.getType());
                        // 利用Java反射调用实体对象的setter方法对属性进行赋值操作
                        method.invoke(t, getData(data, field.getType()));
                    }

                }

            }
            return t;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    private static Object getData(Object data, Class<?> type) {
        String typeName = type.getTypeName();
        //if (StringUtils.equals(typeName, Long.class.getTypeName())) {
            if(data!=null&&data!="null"){
                if(typeName.equals("java.lang.Long")){
                    return Long.valueOf(data.toString());
                }else if(typeName.equals("java.lang.Integer")){
                    return Integer.valueOf(data.toString());
                }else if(typeName.equals("java.lang.String")){
                    return data.toString();
                }else if(typeName.equals("java.util.Date")){
                    return DateUtils.parseDate(data);
                }else{
                    return null;
                }

            }

            /*if (data instanceof Long) {
                return ((Long) data).intValue();
            }*/
       // }
        return data;
    }


    /**
     * 判断字符串是否json格式
     * @param str
     * @return
     */
    public static boolean getJSONType(String str) {
        boolean result = false;
        if (StringUtils.isNotBlank(str)) {
            str = str.trim();
            if (str.startsWith("{") && str.endsWith("}")) {
                result = true;
            } else if (str.startsWith("[") && str.endsWith("]")) {
                result = true;
            }
        }
        return result;
    }


}
