package com.liuyq.jdk.lang;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.junit.Test;

/**
 * Created by liuyq on 2018/3/1.
 */
public class IntegerTest {

    int low = -123;

    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    static int stringSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

    @Test
    public void StringTest(){
        Integer integer = Integer.MIN_VALUE;
        System.out.println(integer.toString(integer, 10));
    }
    @Test
    public void stringSizeTest(){
        System.out.println(stringSize(123));
    }

    @Test
    public void charAtTest(){
        System.out.println("123".charAt(0));
    }

    @Test
    public void decodeTest(){
        System.out.println(Integer.decode("10"));
    }
    @Test
    public void valueofTest(){
        //System.out.println(Integer.valueOf(10));
        System.out.println(-low);
    }
    @Test
    public void hashCodeTest(){
        System.out.println(Integer.hashCode(112));
    }

    @Test
    public void test(){
        String s = " 79008.00000  ";
        System.out.println(stringTOIneger(s));

    }

    private static Integer stringTOIneger(String str){
        if(StringUtils.isEmpty(str)) return 0;
        //真的坑啊（先去前后空格），再截.之前的值
        String kilm = str.trim();
        Integer i = kilm.indexOf(".");
        if(!i.equals(-1)) {
            kilm = kilm.substring(0, kilm.indexOf("."));
        }
        Integer kilmInt = new Integer(kilm);
        return kilmInt;
    }
    @Test
    public void test3(){

        System.out.println(String.format("%03d", 789));
        int n2 = 9999999;
        System.out.printf("%+(,d %n", n2);

    }
    @Test
    public void test4(){
        Integer i = new Integer("13800000000");
    }
}
