package com.djx.demo.leetcode.everyday;

import java.util.Arrays;

/**
 * 1470 [重新排列数组]
 * 1. (打卡) 剑指 Offer 59 - I [滑动窗口的最大值] 🤩
 * 2. (复习 1) 剑指 Offer II 003 [前 n 个数字二进制中 1 的个数]
 * 3. (复习 2) 剑指 Offer II 005 [单词长度的最大乘积]
 * 4. (复习 3) 剑指 Offer II 067 [最大的异或]
 * 5. (每日) 1470 [重新排列数组]
 *
 * @author dongjingxi
 * @date 2022/8/29
 */
public class Shuffle {

    public static void main(String[] args) {

        int[] nums = {2, 5, 1, 3, 4, 7};

        Shuffle shuffle = new Shuffle();

        int[] result = shuffle.shuffle(nums, 3);

        System.out.println(Arrays.toString(result));
    }


    public int[] shuffle(int[] nums, int n) {

        int[] result = new int[nums.length];

        for (int i = 0, j = n, k = 0; i < n; i++, j++) {
            result[k] = nums[i];
            k = k + 1;
            result[k] = nums[j];
            k = k + 1;
        }

        return result;
    }


}
