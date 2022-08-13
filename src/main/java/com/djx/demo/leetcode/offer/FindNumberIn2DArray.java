package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer 04]二维数组中的查找
 * <p>
 * <p>
 * 这个应该是前两天做的二分查找的变种题
 * <p>
 * 现在二维数组中找到，对应范围的行， 再查对应数字
 * <p>
 * 应该还能再优化下， 找行的时候应该也能二分
 *
 * @author dongjingxi
 * @date 2022/8/13
 */
public class FindNumberIn2DArray {


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        for (int[] row : matrix) {
            if (row.length == 0) {
                return false;
            }

            if (target >= row[0] && target <= row[row.length - 1]) {
                if (search(row, target)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        boolean targetIndex = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                targetIndex = true;
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return targetIndex;

    }

}
