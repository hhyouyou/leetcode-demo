package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer 10- I]斐波那契数列	36.2%	Easy	0.0%
 *
 * @author djx
 * @date 2022/8/8 上午10:29
 */
public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(fib2(0));
        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
        System.out.println(fib2(5));
        System.out.println(fib2(50));
    }


    public static int fib(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int fib2 = fib(n - 2);
        int fib1 = fib(n - 1);
        return fib1 + fib2;
    }

    public static int fib2(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        int step1 = 0;
        int step2 = 1;

        int result = 0;
        while (n > 1) {
            result = (step1 + step2) % 1000000007;
            step1 = step2;
            step2 = result;
            n--;
        }

        return result;
    }

}
