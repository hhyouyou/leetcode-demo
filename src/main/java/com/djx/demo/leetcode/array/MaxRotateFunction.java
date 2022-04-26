package com.djx.demo.leetcode.array;

/**
 * @author djx
 * @date 2022/4/22 上午10:38
 */
public class MaxRotateFunction {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(maxRotateFunction(nums));
        System.out.println(maxRotateFunction1(nums));
    }

    public static int maxRotateFunction(int[] nums) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int result = 0;
            for (int j = 0; j < nums.length; j++) {
                result = result + ((i + j) % nums.length) * nums[j];
            }
            max = Math.max(max, result);
        }

        return max;
    }


    /**
     * f(n) =  (f(n-1) - (length - 1) * nums[length - n]) + (sum(nums[]) - nums[length - n])
     */
    public static int maxRotateFunction1(int[] nums) {
        int length = nums.length;

        int arraySum = 0;
        for (int num : nums) {
            arraySum = arraySum + num;
        }

        // f(0)
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result + i * nums[i];
        }
        int max = result;

        // f(1) ~ f(n-1)
        for (int i = 1; i < nums.length; i++) {
            result = result - ((length - 1) * nums[length - i]) + (arraySum - nums[length - i]);
            max = Math.max(max, result);
        }

        return max;
    }

}
