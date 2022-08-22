package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer II 011]0 和 1 个数相同的子数组
 *
 * @author dongjingxi
 * @date 2022/8/22
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            int zero = 0;
            int one = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 0) {
                    zero = zero + 1;
                } else {
                    one = one + 1;
                }

                if (zero == one) {
                    max = Math.max(max, zero + one);
                }
            }
        }


        return max;
    }

}
