package com.liuyq.digit;


/**
 * @Auther: liuyuqing
 * @Date: 2020/3/11 22:34
 * @Description:
 */
public class Test {
    public static long initVal = 0;
    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z' ,
            'A' ,'B','C','D','E','F','G','H',
            'I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X','Y','Z'
    };


    public static long getData() {
        return ++initVal;
    }

    public static String addZeroForNum(String str) {
        int strLen = str.length();
        StringBuffer sb = null;
        while (strLen < 4) {
            sb = new StringBuffer();
            sb.append("0").append(str);// 左补0
            str = sb.toString();
            strLen = str.length();
        }
        return str;
    }

    /**
     * 转换方法
     *
     * @param num       元数据字符串
     * @param fromRadix 元数据的进制类型
     * @param toRadix   目标进制类型
     * @return
     */
    static String transRadix(String num, int fromRadix, int toRadix) {
        int number = Integer.valueOf(num, fromRadix);
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(digits[number % toRadix]);
            number = number / toRadix;
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        for (int i = 0; i <= 4665400; i++) {// 46654
            long old = getData();
            System.out.println("原始数据" + old);
            String num36 = addZeroForNum(Long.toString(old, 36));
            System.out.println("36进制数" + num36);

            String oldStre = transRadix(num36, 36, 10);
            System.out.println("36进制转化之后的值"+oldStre);
            if(oldStre.equals(Long.toString(i))){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
    }

}
