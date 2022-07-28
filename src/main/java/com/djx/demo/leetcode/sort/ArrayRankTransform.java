package com.djx.demo.leetcode.sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * day	[1331]数组序号转换	60.3%	Easy	0.0%
 * <p>
 * <p>
 * 排序变种题
 * <p>
 * <p>
 * 排完序后， 在原数组中， 用排序需要替换原数字（如果大小一样，序号也一样）
 *
 * @author dongjingxi
 * @date 2022/7/28
 */
public class ArrayRankTransform {


    public static void main(String[] args) {

        int[] test = {40, 10, 20, 30};

        ArrayRankTransform arrayRankTransform = new ArrayRankTransform();

        int[] result = arrayRankTransform.arrayRankTransform(test);

        System.out.println(Arrays.toString(result));

    }


    public int[] arrayRankTransform(int[] arr) {

        int[] clone = arr.clone();

        quickSort(clone, 0, clone.length - 1);


        // 转map， num-index
        HashMap<Integer, Integer> numSortMap = new HashMap<>(clone.length);
        int index = 1;
        for (int j : clone) {
            if (!numSortMap.containsKey(j)) {
                numSortMap.put(j, index++);
            }
        }

        // 替换num -> sort Index
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numSortMap.get(arr[i]);
        }

        return arr;
    }


    public void quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int mailTail = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, ++mailTail);
            }
        }
        swap(arr, left, mailTail);

        quickSort(arr, left, mailTail);
        quickSort(arr, mailTail + 1, right);
    }


    public void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}
