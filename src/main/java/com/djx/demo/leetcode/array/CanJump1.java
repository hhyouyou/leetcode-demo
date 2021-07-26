package com.djx.demo.leetcode.array;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * 55.跳跃游戏
 *
 * @author djx
 * @date 2021/7/16 上午11:24
 */
public class CanJump1 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] nums = {3, 0, 8, 2, 0, 0, 1};
//        int[] nums = testCase();

        System.out.println(Arrays.toString(nums));

        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) throws ExecutionException, InterruptedException {

        return greedy(nums);
//        return jump1(nums, 0);
    }

    /**
     * 方法一: 贪心算法
     */
    public static boolean greedy(int[] nums) {

        // 记录最远可达位置
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max >= i) {

                max = Math.max(max, i + nums[i]);

                if (max >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }


    public static boolean jump1(int[] nums, int index) {
        int step = nums[index];

        if (index == nums.length - 1) {
            return true;
        }

        for (int i = 1; i <= step; i++) {

            int next = index + i;
            if (next < 0 || next >= nums.length) {
                break;
            }
            boolean success = jump1(nums, next);
            if (success) {
                System.out.println(next);
                return true;
            }
        }

        return false;

    }


    public static int[] testCase() {
        int[] nums = new int[10002];

        int start = 9999;

        for (int i = 0; i < 10000; i++) {
            nums[i] = start--;
        }

        nums[10000] = 0;
        nums[10001] = 0;

        return nums;
    }


}
