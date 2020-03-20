package com.liuyq.jdk.lang;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liuyq on 2018/3/2.
 */
    public class StringTest {

    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                   char[] target, int targetOffset, int targetCount,
                   int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    @Test
    public void hashTest(){
        System.out.println("123".hashCode());
    }
    @Test
    public void test(){
        String s = new String(new int[]{122322,122322,122322,122322},0,3);
        System.out.println(s);
    }
    @Test
    public void testCodePointAt(){
        String s = "1!34";
        System.out.println(s.charAt(1));
        //返回对应char的ASCII码10进制数
        System.out.println(s.codePointAt(1));
        //返回index前面一位的char的ASCII的10进制数
        System.out.println(s.codePointBefore(1));
    }

    @Test
    public void testCompareTo(){
        String s = "12";
        System.out.println(s.compareTo("12"));
    }

    @Test
    public void testCompareToIgnoreCase(){
        String s = "AB";
        System.out.println(s.compareToIgnoreCase("B"));
    }
    @Test
    public void testCharAt(){
        String s = "A";
        char a = s.charAt(0);
        System.out.println(a);
    }
    @Test
    public void testIndexOf(){
       /* String s = "hello world";
        //System.out.println(s.indexOf("w",4)); //当目标字符串是空串的时候，直接返回开始索引的值
       // System.out.println(s.indexOf("",-1)); //当开始索引值小于0的时候，返回0

       // System.out.println(s.indexOf(50,1));
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if('h' == 104){
                System.out.println("这");
            }
            System.out.println(chars[i]);
        }*/
        char[] source = {'0','1','2','3','4','5','6','7','8'};
        char[] target ={'2','6','4'};
        System.out.println(indexOf(source, 0, 9, target, 0,3, 0));

    }

    @Test
    public void testConcat(){
        String s = "liu";
        System.out.println(s.concat("yu"));
    }

    @Test
    public void testReplace(){
        String s ="121212121212121212";
        System.out.println(s.replace('2','3'));

    }

    @Test
    public void testsplit(){
        String s ="hello word wew wre";
        String[] strings = s.split("#");
        System.out.println(strings);
    }

    @Test
    public void testw(){
        char ch = '0';
        String s = "\\#";
        System.out.println((((ch = s.charAt(1))-'0')|('9'-ch)));
        System.out.println((((ch = s.charAt(1))-'A')|('Z'-ch)));
        System.out.println((((ch = s.charAt(1))-'a')|('z'-ch)));
        System.out.println((s.length() == 2 &&
                s.charAt(0) == '\\' &&
                (((ch = s.charAt(1))-'0')|('9'-ch)) < 0 &&
                ((ch-'a')|('z'-ch)) < 0 &&
                ((ch-'A')|('Z'-ch)) < 0));
    }

    @Test
    public void testSplit(){
        String s = "wewewewwwaw";
        String[] strings = s.split("w");
        System.out.println(strings);
    }
    @Test
    public void testTrim(){
        String s = "   234234234 ";
        System.out.println(s.trim());
    }
    @Test
    public void testTrim2(){
        double a = 0.1;
        System.out.println(new BigDecimal(a));
        System.out.println(BigDecimal.valueOf(a));
    }

    @Test
    public void test4(){
        int rows = 700;
        String str = "这红色isif噢爱好大Sof爱啊的说法我好的佛爱活动飞的是否哈德发到罚单的说法打法地方都是法儿童我让他";
        List<String> stringList  = getStrList(str, 10);
        System.out.println(stringList);
    }

    public static List<String> getStrList(String inputString, int length) {
        int size = inputString.length() / length;
        if (inputString.length() % length != 0) {
            size += 1;
        }
        return getStrList(inputString, length, size);
    }

    public static List<String> getStrList(String inputString, int length,
                                          int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length,
                    (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }

    public static String substring(String str, int f, int t) {
        if (f > str.length())
            return null;
        if (t > str.length()) {
            return str.substring(f, str.length());
        } else {
            return str.substring(f, t);
        }
    }

    @Test
    public void test1(){
        Long l = 20180730061744L;
        System.out.println(new Date(l));
    }

    @Test
    public void testStringUtil(){
        System.out.println(StringUtils.leftPad("1",4,"0"));
        System.out.println(StringUtils.leftPad("11",4,"0"));
        System.out.println(StringUtils.leftPad("111",5,"0"));

    }

    /**
     * SimpleDateFormat 和 FastDateFormat
     * （1）SimpleDateFormat是线程不安全的 FastDateFormat是线程安全的
     *  （2）使用SimpleDateFormat 需要每次都new ， FastDateFormat 则缓存了FastDateFormat ，相同的pattern 回一直使用同一个fastDateFormate
     */
    @Test
    public void testFastDayFormate(){
        String pattern = "yyyy-MM-dd HH:MM:ss";

        SimpleDateFormat format = new SimpleDateFormat(pattern);
        FastDateFormat fastDateFormat = FastDateFormat.getInstance(pattern);

        System.out.println(format.format(new Date()));
        System.out.println(fastDateFormat.format(new Date()));
    }
}