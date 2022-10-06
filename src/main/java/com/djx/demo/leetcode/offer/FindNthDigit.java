package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer 44]数字序列中某一位的数字
 *
 * @author dongjingxi
 * @date 2022/8/9
 */
public class FindNthDigit {

    public static void main(String[] args) {


//        System.out.println(findNthDigit(1));
//        System.out.println(findNthDigit(6));
//        System.out.println(findNthDigit(27));
//        System.out.println(findNthDigit(140));
//        System.out.println(findNthDigit(240));
        System.out.println(findNthDigit(190));
        System.out.println(findNthDigit(189));
        System.out.println(findNthDigit(191));

    }

    public static int findNthDigit1(int n) {
        if (n == 0) {
            return 0;
        }
        int bit = 0;
        double bitMax = 1;
        int tmp = n - 1;
        for (int i = 1; i < 10; i++) {
            double x = 9 * i * Math.pow(10, i - 1);

            if (tmp > x) {
                tmp = (int) (tmp - x);
            } else {
                bit = i;
                break;
            }
        }

        System.out.println("tmp: " + tmp);
        System.out.println("n: " + n);

        // 每行多少个数字
        int a = (int) (bit * Math.pow(10, bit - 1));
        int row = tmp / a;
        int column = tmp % a;

        return bit;
    }


    public static int findNthDigit(int n) {

        int digit = 1;
        int start = 1;
        long count = 9;

        while (n > count) {

            n = (int) (n - count);

            start = start * 10;
            digit = digit + 1;
            count = (long) 9 * digit * start;
        }

        int num = start + (n - 1) / digit;

        String s = Integer.toString(num);
        char c = s.charAt((n - 1) % digit);
        return Integer.parseInt(String.valueOf(c));

    }


}
