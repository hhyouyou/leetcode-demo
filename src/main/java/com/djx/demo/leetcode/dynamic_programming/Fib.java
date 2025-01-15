package com.djx.demo.leetcode.dynamic_programming;

/**
 * 509. 斐波那契数
 */
public class Fib {
    public static void main(String[] args) {
        int dynamic = dynamic(1);
        System.out.println(dynamic);
    }

    public static int dynamic(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int result1 = 0;
        int result2 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = result1 + result2;
            result1 = result2;
            result2 = tmp;
        }
        return result2;
    }
}
