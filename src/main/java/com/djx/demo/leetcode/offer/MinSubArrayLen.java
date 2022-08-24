package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer II 008]和大于等于 target 的最短子数组
 *
 * @author dongjingxi
 * @date 2022/8/23
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {

        int min = nums.length + 1;


        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum = sum + nums[end];
                if (sum >= target) {
                    min = Math.min(min, end - start + 1);
                }
            }

        }


        return min > nums.length ? 0 : min;
    }
}
