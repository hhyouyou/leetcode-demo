package com.djx.demo.leetcode.array;

import com.djx.demo.leetcode.util.Utils;

import java.util.Arrays;

/**
 * 1877 数组中最大对数和的最小值
 *
 * @author djx
 * @date 2021/7/20 上午10:28
 */
public class MinPairSum {

    public static void main(String[] args) {

        int[] randomArray = Utils.getRandomArray(100, 20);
        check(randomArray);

    }

    public static int check(int[] nums) {
        minPairSum(nums);
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        int[] pair = new int[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            pair[i] = nums[i] + nums[nums.length - 1 - i];
        }

        System.out.println(Arrays.toString(pair));
        quickSort(pair, 0, pair.length - 1);
        System.out.println(Arrays.toString(pair));

        return 0;
    }

    public static int minPairSum(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
        Arrays.sort(nums);

        int max = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max, nums[i] + nums[nums.length - 1 - i]);
        }

        return max;
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
