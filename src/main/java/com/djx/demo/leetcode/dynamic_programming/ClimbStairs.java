package com.djx.demo.leetcode.dynamic_programming;

/**
 * 70. 爬楼梯
 * easy
 */
public class ClimbStairs {


    public static void main(String[] args) {
        int result = climbStairs(6);
        int dynamic = dynamic(6);
        System.out.println(result);
        System.out.println(dynamic);
    }

    public static int climbStairs(int n) {
        return fbi(n);
    }


    public static int fbi(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fbi(n - 1) + fbi(n - 2);
    }

    public static int dynamic(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int result1 = 1;
        int result2 = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = result1 + result2;
            result1 = result2;
            result2 = tmp;
        }
        return result2;
    }

//    n = 1 : 1
//    n = 2 : 1+1 、 2
//    n = 3 : 1 + 2 、1+1+1、 2+1  第一步走1还是2 ， 走1还剩下2阶梯， 走2还剩下1阶梯
//    n = 4 : 1 + 3 、2+2     1+3 有3种  2+2有 2种  总计 5种
//    n = 5 : 1 + 4 、2+3     5+3 = 8
}
