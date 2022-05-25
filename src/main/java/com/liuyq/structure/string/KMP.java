package com.liuyq.structure.string;

/**
 * @author liuyuqing
 * @className KMP
 * @description 参考： https://zhuanlan.zhihu.com/p/83334559
 * @date 2022/1/13 10:08 上午
 */
public class KMP {
    /**
     * 0 <= j < M，代表当前的状态
     * 0 <= c < 256，代表遇到的字符（ASCII 码）
     * 0 <= next <= M，代表下一个状态
     */
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 当前状态 j 从 1 开始
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(j) == c)
                    dp[j][c] = j + 1;
                else
                    dp[j][c] = dp[X][c];
            }
            // 更新影子状态
            System.out.println("开始X：" + X + ",字符串：" + pat.charAt(j));
            X = dp[X][pat.charAt(j)];
            System.out.println("截止X:" + X);

            System.out.println("---------------------------");
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 当前是状态 j，遇到字符 txt[i]，
            // pat 应该转移到哪个状态？
            j = dp[j][txt.charAt(i)];
            // 如果达到终止态，返回匹配开头的索引
            if (j == M) return i - M + 1;
        }
        // 没到达终止态，匹配失败
        return -1;
    }

    //        A  B  A  B  C
    // 状态图 0->1->2->3->4->5
    public static void main(String[] args) {
        //KMP kmp = new KMP("ABABC");
       // System.out.println(kmp);
    }
}
