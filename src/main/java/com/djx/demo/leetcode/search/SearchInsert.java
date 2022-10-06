package com.djx.demo.leetcode.search;

/**
 * @author dongjingxi
 * @date 2022/2/20
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 7, 8};
        System.out.println(searchInsert(nums, 6));

    }


    /**
     * 二分查找
     */
    public static int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }


    public static int searchInsert(int[] nums, int target, int start, int end) {

        if (end < start) {
            return -1;
        }
        int mid = start + (end - start) >> 1;

        if (mid == 0 || mid == nums.length - 1) {
            return mid;
        }

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            if (nums[mid + 1] > target) {
                return mid;
            }
            return searchInsert(nums, target, mid + 1, end);
        } else {
            if (nums[mid - 1] < target) {
                return mid - 1;
            }
            return searchInsert(nums, target, start, mid - 1);
        }
    }

}
