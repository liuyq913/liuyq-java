package com.liuyq.jdk.reflect;

import java.lang.reflect.Method;

/**
 * Created by liuyq on 2019/4/11.
 */
public class ReflectUtil {

    /**
     *  通过反射返回元素的值
     */
    public static Object invokeGetMothod(Class clazz, Object o, String name){
        Object result = null;
        try{
            Method method =  clazz.getMethod("get"+firstCharUpperCase(name));
            result = method.invoke(o);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     *首字母大写
     * @param s
     * @return
     */
    public static String firstCharUpperCase(String s) {
        StringBuffer sb = new StringBuffer(s.substring(0, 1).toUpperCase());
        sb.append(s.substring(1, s.length()));
        return sb.toString();
    }

    public static String objectToStr(Object o){
        if(o == null) return "";
        String str = "";
        if(o instanceof String){
            str = (String) o;
        }else{
            str = o.toString();
        }
        return str;
    }

}
