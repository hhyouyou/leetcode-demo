package com.djx.demo.leetcode.everyday;

/**
 * [1464]数组中两元素的最大乘积
 *
 * @author djx
 * @date 2022/8/26 上午11:01
 */
public class MaxProduct {

    public static void main(String[] args) {

        int[] nums = {1, 5, 4, 5};

        System.out.println(maxProduct1(nums));
    }

    public static int maxProduct(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return max;
    }

    public static int maxProduct1(int[] nums) {
        int max = nums[0] - 1;
        int maxNext = 0;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i] - 1;
            if (curr > max) {
                maxNext = max;
                max = curr;
            } else if (curr > maxNext) {
                maxNext = curr;
            }
        }
        return max * maxNext;
    }

}
