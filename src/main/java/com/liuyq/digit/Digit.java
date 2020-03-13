package com.liuyq.digit;

/**
 * @Auther: liuyuqing
 * @Date: 2020/3/11 22:03
 * @Description:
 */
public class Digit {
    /*** 在进制表示中的字符集合。*/
    final static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z'
    };

    /**
     * 10->62 进制
     *
     * @param seq
     * @return
     */

    private static String to62RadixString(long seq) {
        StringBuilder sBuilder = new StringBuilder();
        while (true) {
            int remainder = (int) (seq % 62);
            sBuilder.append(digits[remainder]);
            seq = seq / 62;
            if (seq == 0) {
                break;
            }
        }
        return sBuilder.reverse().toString();
    }

    public static void main(String[] agrs) {
        for (int i = 0; i < 1000000; i++) {
            System.out.println("10进制数"+i);
            System.out.println("62进制数"+to62RadixString(i));
        }
    }

}
