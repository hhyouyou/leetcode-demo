package com.djx.demo.leetcode.everyday;

import java.util.Arrays;

/**
 * [88]合并两个有序数组
 *
 * @author dongjingxi
 * @date 2022/3/10
 */
public class Merge {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 5, 6, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 4};

        merge(nums1, 4, nums2, 4);

        System.out.println(Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {


        for (int i = nums1.length - 1; i >= 0; i--) {

            if (m == 0) {
                nums1[i] = nums2[n - 1];
                n--;
                continue;
            }
            if (n == 0) {
                nums1[i] = nums1[m - 1];
                m--;
                continue;
            }

            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }


        }


    }


}
