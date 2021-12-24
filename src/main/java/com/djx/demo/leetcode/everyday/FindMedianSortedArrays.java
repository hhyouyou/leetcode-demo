package com.djx.demo.leetcode.everyday;

import java.util.Arrays;

/**
 * [4]寻找两个正序数组的中位数
 *
 * @author djx
 * @date 2021/10/15 下午4:32
 */
public class FindMedianSortedArrays {


    public static void main(String[] args) {

//        int[] num1 = Utils.getRandomArray(8);
//        int[] num2 = Utils.getRandomArray(6);

        int[] num1 = {1, 2};
        int[] num2 = {3, 4, 5};

        Arrays.sort(num1);
        Arrays.sort(num2);

        System.out.println("num1:" + Arrays.toString(num1));
        System.out.println("num2:" + Arrays.toString(num2));
        System.out.println(findMedianSortedArrays2(num1, num2));
    }

    /**
     * 基础的思路, 合并两个数组, 然后取中位数
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int mid = (totalLength) / 2;

        int[] sum = new int[totalLength];

        for (int i = 0, j = 0, k = 0; i < nums1.length || j < nums2.length; ) {

            if (i >= nums1.length && j < nums2.length) {
                sum[k++] = nums2[j++];
            }

            if (i < nums1.length && j >= nums2.length) {
                sum[k++] = nums1[i++];
            }

            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    sum[k++] = nums1[i++];
                } else {
                    sum[k++] = nums2[j++];
                }
            }
        }

        if (totalLength % 2 == 0) {
            double doubleSum = sum[mid] + sum[mid - 1];
            return doubleSum / 2;
        } else {
            return sum[mid];
        }
    }


    /**
     * 其实我只需要中位数, 我计算整个干嘛呢???
     * 优化1, for循环,不用 m+n次, m+n/2次就够了
     * 优化2, 不用真的合并存整个sum队列, 只需要记录, 中位数 ,最多两个数字就够了
     * <p>
     * ps: 偶数个数字,需要两个中位数
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int totalLength = nums1.length + nums2.length;
        int mid = (totalLength) / 2;

        int minNumCache = -1;
        int midNum = -1;

        int startOne = 0;
        int startTwo = 0;

        for (int i = 0; i <= mid; i++) {
            minNumCache = midNum;

            if (startOne < nums1.length && startTwo >= nums2.length) {
                midNum = nums1[startOne++];
            }

            if (startOne >= nums1.length && startTwo < nums2.length) {
                midNum = nums2[startTwo++];
            }

            if (startOne < nums1.length && startTwo < nums2.length) {
                if (nums1[startOne] < nums2[startTwo]) {
                    midNum = nums1[startOne++];
                } else {
                    midNum = nums2[startTwo++];
                }
            }

        }

        if (totalLength % 2 == 0) {
            double doubleSum = minNumCache + midNum;
            return doubleSum / 2;
        } else {
            return midNum;
        }
    }

}
