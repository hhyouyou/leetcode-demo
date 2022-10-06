package com.djx.demo.leetcode.everyday;

/**
 * [868]二进制间距 Easy
 *
 * @author djx
 * @date 2022/4/24 下午4:05
 */
public class BinaryGap {

    public static void main(String[] args) {

        System.out.println(binaryGap(0));
    }

    public static int binaryGap(int n) {

        int max = 0;

        int index = -1;

        for (int i = 0; n != 0; i++) {
            int yu = n % 2;
            n = n / 2;
            if (yu == 1) {
                if (index != -1) {
                    max = Math.max(max, i - index);
                }
                index = i;
            }
            System.out.println(yu + "_" + n);
        }

        return max;
    }

}
