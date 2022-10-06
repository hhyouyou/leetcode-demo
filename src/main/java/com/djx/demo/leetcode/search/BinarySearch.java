package com.djx.demo.leetcode.search;

/**
 * @author dong jing xi
 * @date 2021/3/30 22:39
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(search(nums, 10));

    }


    /**
     * 二分查找
     */
    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }


    public static int search(int[] nums, int target, int start, int end) {

        if (end < start) {
            return -1;
        }
        int mid = (end + start) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search(nums, target, start, mid - 1);
        } else {
            return search(nums, target, mid + 1, end);
        }
    }


}
