package com.liuyq.jdk.lang;

import org.junit.Test;

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

    }
}