package com.djx.demo.leetcode.everyday;

/**
 * [713]乘积小于 K 的子数组
 *
 * @author dongjingxi
 * @date 2022/5/5
 */
public class NumSubarrayProductLessThanK {


    public static void main(String[] args) {

        int[] nums = {10, 5, 2, 6};

        System.out.println(numSubarrayProductLessThanK(nums, 2));

    }


    /**
     *思路： 循环，如果有<k的就乘上下一个数字，直到>=k
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < k) {
                count = count + 1;
                for (int j = i + 1; j < nums.length; j++) {
                    num = num * nums[j];
                    if (num < k) {
                        count = count + 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

}
