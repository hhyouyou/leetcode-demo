package com.djx.demo.leetcode.array;

/**
 * [剑指 Offer 61]扑克牌中的顺子
 *
 * @author djx
 * @date 2021/12/24 下午4:57
 */
public class IsStraight {


    public static void main(String[] args) {

    }


    public boolean isStraight(int[] nums) {

        quickSort(nums, 0, nums.length - 1);


        return false;
    }


    public static void quickSort(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }
        int minTail = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < array[left]) {
                swap(array, i, ++minTail);
            }
        }
        swap(array, left, minTail);

        quickSort(array, left, minTail);
        quickSort(array, minTail + 1, right);

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
