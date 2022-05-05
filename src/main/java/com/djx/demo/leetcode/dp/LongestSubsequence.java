package com.djx.demo.leetcode.dp;

import java.util.HashMap;

/**
 * [1218]最长定差子序列
 *
 * @author dongjingxi
 * @date 2022/5/5
 */
public class LongestSubsequence {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        System.out.println(longestSubsequence(nums, 1));

    }


    /**
     * 每个数字都往后找， 找到一个符合等差的，就继续按这个往后找，不停的替换不停的遍历
     * <p>
     * 优化：因为是等差，所以其实同一个等差子序列会被遍历多次
     */
    public static int longestSubsequence(int[] arr, int difference) {

        int max = 0;
        HashMap<Integer, Integer> arrMap = new HashMap<>(arr.length);
        for (int j : arr) {
            Integer count = arrMap.getOrDefault(j - difference, 0);
            arrMap.put(j, count + 1);
            max = Math.max(max, count + 1);
        }
        return max;
    }

}
