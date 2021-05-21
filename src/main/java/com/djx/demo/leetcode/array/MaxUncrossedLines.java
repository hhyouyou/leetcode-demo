package com.djx.demo.leetcode.array;

/**
 * 1035 不相交的线
 *
 * @author djx
 * @date 2021/5/21 上午10:26
 */
public class MaxUncrossedLines {

    public static void main(String[] args) {

        int[] nums1 = {1, 4, 2};
        int[] nums2 = {1, 2, 4};
        int i = maxUncrossedLines(nums1, nums2);
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
}
