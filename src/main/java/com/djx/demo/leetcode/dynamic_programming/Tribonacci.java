package com.djx.demo.leetcode.dynamic_programming;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 */
public class Tribonacci {
    public static void main(String[] args) {

        int dynamic = dynamic(1);
        System.out.println(dynamic);
    }


    public static int dynamic(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int step1 = 0;
        int step2 = 1;
        int step3 = 1;

        for (int i = 3; i <= n; i++) {
            int tmp = step1 + step2 + step3;
            step1 = step2;
            step2 = step3;
            step3 = tmp;
        }
        return step3;
    }
}
