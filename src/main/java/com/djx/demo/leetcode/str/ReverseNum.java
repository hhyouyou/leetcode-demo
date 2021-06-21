package com.djx.demo.leetcode.str;

/**
 * @author djx
 * @date 2021/6/21 下午2:31
 */
public class ReverseNum {


    public static void main(String[] args) {

        int reverse = reverse(1534236469);
        System.out.println(reverse);
    }

    public static int reverse(int x) {

        long result = 0;

        while (x != 0) {
            int remainder = x % 10;

            result = remainder + result * 10;

            x = x / 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return Math.toIntExact(result);
    }


}
