package com.djx.demo.leetcode.everyday;

/**
 * [1732]找到最高海拔
 *
 * @author djx
 * @date 2021/10/14 下午9:28
 */
public class LargestAltitude {

    public static void main(String[] args) {

        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;

        int the = 0;

        for (int i : gain) {

            the = the + i;
            if (the > max) {
                max = the;
            }
        }

        return max;
    }

}
