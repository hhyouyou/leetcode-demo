package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer 53 - I]在排序数组中查找数字
 * [剑指 Offer 53 - II]0～n-1中缺失的数字
 *
 * @author dongjingxi
 * @date 2022/8/11
 */
public class SearchNumber {


    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8;
//        int search = search1(nums, target);
//        System.out.println(search);

        int[] missingNums = {1};

        System.out.println(missingNumber(missingNums));
    }

    public static int search1(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int targetIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                targetIndex = mid;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (targetIndex == -1) {
            return 0;
        }

        int count = 1;

        for (int i = targetIndex - 1; i >= 0; i--) {
            if (nums[i] == target) {
                count = count + 1;
            }
        }

        for (int i = targetIndex + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                count = count + 1;
            }
        }

        return count;
    }

    public static int search(int[] nums, int target) {

        int targetIndex = findTarget(nums, target, 0, nums.length - 1);

        if (targetIndex == -1) {
            return 0;
        }

        int count = 1;

        for (int i = targetIndex - 1; i >= 0; i--) {
            if (nums[i] == target) {
                count = count + 1;
            }
        }

        for (int i = targetIndex + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                count = count + 1;
            }
        }

        return count;
    }

    private static int findTarget(int[] nums, int target, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (target == nums[mid]) {
            return mid;
        } else if (target == nums[left]) {
            return left;
        } else if (target == nums[right]) {
            return right;
        } else if (target > nums[mid] && target < nums[right]) {
            return findTarget(nums, target, mid + 1, right);
        } else if (target > nums[left] && target < nums[mid]) {
            return findTarget(nums, target, left, mid - 1);
        }
        return -1;

    }


    public static int missingNumber(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int max = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == mid) {
                max = Math.max(mid, max);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (max == -1) {
            return 0;
        }

        return max + 1;
    }

}
