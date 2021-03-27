package com.djx.demo.leetcode.sort;

import com.djx.demo.leetcode.util.Utils;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author dong jing xi
 * @date 2020/4/28 15:05
 **/
public class MergeSort {

    public static void main(String[] args) {
//        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
//        mergeSort(arrays, 0, arrays.length - 1);
//        System.out.println(Arrays.toString(arrays));

        Utils.testSort(1000, MergeSort::mergeSort);
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] arrays, int begin, int end) {
        if (begin == end) {
            return;
        }

        int mid = (end + begin) / 2;
        // 左划分一块
        mergeSort(arrays, begin, mid);
        // 右划分一块
        mergeSort(arrays, mid + 1, end);

        merge(arrays, begin, mid, end);

    }

    private static void merge(int[] arrays, int begin, int mid, int end) {

        int[] back = Arrays.copyOfRange(arrays, begin, end + 1);

        int i = begin;
        int j = mid + 1;
        for (int k = begin; k <= end; k++) {
            if (i > mid) {
                arrays[k] = back[j++ - begin];
            } else if (j > end) {
                arrays[k] = back[i++ - begin];
            } else if (back[i - begin] < back[j - begin]) {
                arrays[k] = back[i++ - begin];
            } else {
                arrays[k] = back[j++ - begin];
            }
        }

    }


}
