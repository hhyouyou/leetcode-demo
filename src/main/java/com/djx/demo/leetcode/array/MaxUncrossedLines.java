package com.djx.demo.leetcode.array;

/**
 * 1035 不相交的线
 *
 * @author djx
 * @date 2021/5/21 上午10:26
 */
public class MaxUncrossedLines {

    public static void main(String[] args) {

        //  [2,5,1,2,5],  [10,5,2,1,5,2]

        int[] nums1 = {2,5,1,2,5};
        int[] nums2 = {10,5,2,1,5,2};
        int i = maxUncrossedLines1(nums1, nums2);
        System.out.println(i);
    }


    public static int maxUncrossedLines(int[] nums1, int[] nums2) {

        int count = 0;
        exist(nums1, 0, nums2, 0, count);

        return count;
    }


    public static int exist(int[] nums1, int target, int[] nums2, int begin, int count) {
        if (begin >= nums2.length && target >= nums1.length) {
            return -2;
        }

        for (int i = begin; i < nums2.length; i++) {
            if (nums1[target] == nums2[i]) {


                return i;
            }
        }

        return -1;
    }

    public static int maxUncrossedLines1(int[] nums1, int[] nums2) {

        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            int char1 = nums1[i - 1];
            for (int j = 1; j <= nums2.length; j++) {
                int char2 = nums2[j - 1];
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }





}
