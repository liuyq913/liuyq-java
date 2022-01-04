package com.liuyq.structure.string;

/**
 * @author liuyuqing
 * @className BM
 * @description
 * @date 2021/10/12 2:51 下午
 */
public class BM {


    // 模式串位置散列表的大小
    private static final int SIZE = 256;

    /**
     * 散列模式串字符所处位置，以及模式串的值， 这样坏字符的寻找就特别快，时间复杂度就是O(1)
     * <p>
     * bc 下标为模式串单个字符的ASCII 的值
     * bc 中存储的的值是模式串值的在模式串中的位置
     * </p>
     *
     * @param b  模式串
     * @param bc 模式串存储位置的散列表
     */
    private void generateBC(char[] b, int[] bc) {
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;  // 初始化散列表为-1
        }


        for (int k = 0; k < b.length; k++) {
            int ascii = b[k]; // 取每个模式串的值的ascii
            bc[ascii] = k;
        }
    }

    /**
     * bm算法实现（包含坏字符实现）
     *
     * @param a 主串
     * @param b 模式串
     */
    private int bm(char[] a, char[] b) {
        // 散列表
        int[] bc = new int[SIZE];
        int bIndex = b.length - 1; //模式串的下标
        int aIndex = a.length - 1; //主串的下标

        // 构建散列表
        generateBC(b, bc);

        // j 表示子串和主串对齐的第一个字符
        int j = 0;

        while (j < aIndex - bIndex) {

            // 模式串的最后一个位置
            int i;
            for (i = bIndex; i >= 0; i--) {
                // j+i 是对比主串的位置
                if (b[j + i] != a[i]) {
                    break;
                }
            }

            // 找到了位置
            if (i < 0) {
                return j;
            }
            //找到坏字符在在模式串下的位置
            int x1 = bc[a[i]]; // 坏字符下标

            // 移动模式串
            // 修改 j的值来改变j 在主串的和模式串第一个值的对应的值，
            // 模式串无需移动，只是改变主串的相对开始匹配的位置
            j = j + i - x1;


        }

        // 没找到
        return -1;
    }


    /**
     * 构建模式串的所有后缀子串，在模式串匹配的位置 int[] suffix
     * 构建模式串的后缀子串， 是否有前缀和模式串的前缀子串相匹配  boolean[] prefix
     */

// b表示模式串，m表示长度，suffix，prefix数组事先申请好了
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) { // 初始化
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; ++i) { // b[0, i]
            int j = i;
            int k = 0; // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m-1-k]) { // 与b[0, m-1]求公共后缀子串
                --j;
                ++k;
                suffix[k] = j+1; //j+1表示公共后缀子串在b[0, i]中的起始下标
            }
            if (j == -1) prefix[k] = true; //如果公共后缀子串也是模式串的前缀子串
        }
    }
}
