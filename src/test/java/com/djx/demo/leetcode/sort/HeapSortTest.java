package com.djx.demo.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest {

    public static void main(String[] args) {
        int[] arr = {1, 4, 23, 2, 6, 9, 13, 5, 45, 12};
        int k = 0;
        System.out.println(findKth(arr, k));

     //   testMinHeapify();

    }
    // 题目 ： 查找数组 arr 中第 k 小的奇数，如果不存在则返回 0. (arr [i] > 0 (i>=0))
    // 思路 ： 维护一个k+1的最小堆， 每次把新加入的替换掉第一个，然后对剩下的选出最小，直到结束，然后 array 1就是第k小的喽
    //


    public static int findKth(int[] arr, int k) {

        int[] kArr = new int[k + 1];
        for (int i : arr) {
            if (i % 2 == 1) {
                kArr[0] = i;
                minHeapify(kArr, 0, k + 1);
            }
        }
        return kArr[1];
    }


    @Test
    public static void testMinHeapify() {

        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};

        // 1.建堆
        buildMaxHeap(arrays);
        int length = arrays.length;
        // 2.把第一个堆顶的数字移动到最后，然后对剩下的数字重新维护最大堆
        // 重复2
        for (int i = length - 1; i > 1; i--) {
            swap(arrays, 0, i);
            minHeapify(arrays, 0, i);
        }

        System.out.println(Arrays.toString(arrays));

    }

    // 建堆，从中间开始维护最小堆
    public static void buildMaxHeap(int[] arrays) {
        for (int i = (arrays.length / 2) + 1; i >= 0; i--) {
            minHeapify(arrays, i, arrays.length);
        }
    }

    public static void minHeapify(int[] array, int i, int length) {

        // 左右子节点在数组中下标
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 根节点和两个子节点中最大的那个元素的下标
        int min = i;
        if (left < length) {
            if (array[left] < array[min]) {
                min = left;
            }
        }
        if (right < length) {
            if (array[right] < array[min]) {
                min = right;
            }
        }

        if (min != i) {
            swap(array, i, min);
            minHeapify(array, min, length);
        }

    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}