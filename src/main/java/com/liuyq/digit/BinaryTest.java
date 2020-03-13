package com.liuyq.digit;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/11 22:28
 * @Description:
 */
public class BinaryTest {
    //设置字符数组
    //可以添加任意不重复字符，提高能转换的进制的上限
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z' ,
            'A' ,'B','C','D','E','F','G','H',
            'I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X',
            'Y','Z'
    };

    /**
     * 转换方法
     * @return
     */
    static String transRadix(long i, int radix) {
        char[] buf = new char[65];
        int charPos = 64;
        boolean negative = (i < 0);

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = digits[(int)(-(i % radix))];
            i = i / radix;
        }
        buf[charPos] = digits[(int)(-i)];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (65 - charPos));

    }
    //测试
    public static void main(String[] args) {
        System.out.println(transRadix(11, 62));
    }
}
