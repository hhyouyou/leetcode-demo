package com.djx.demo.leetcode.sort;

import com.djx.demo.leetcode.util.Utils;

/**
 * 堆排序
 *
 * @author dong jing xi
 * @date 2020/4/28 21:24
 **/
public class HeapSort {

    public static void main(String[] args) {

        Utils.testSort(100000, HeapSort::heapSort);
        Utils.testSort(100000, HeapSort::heapSort);
        Utils.testSort(100000, HeapSort::heapSort);
        Utils.testSort(100000, HeapSort::heapSort);
        Utils.testSort(100000, HeapSort::heapSort);
        Utils.testSort(100000, HeapSort::heapSort);
    }

    public static void heapSort(int[] arrays) {
        // 1.建堆
        buildMaxHeap(arrays);
        int length = arrays.length;
        // 2.把第一个堆顶的数字移动到最后，然后对剩下的数字重新维护最大堆
        // 重复2
        for (int i = length - 1; i > 1; i--) {
            swap(arrays, 0, i);
            maxHeapify(arrays, 0, i);
        }
    }


    /**
     * 建堆，从中间开始维护最大堆
     *
     * @param arrays
     */
    public static void buildMaxHeap(int[] arrays) {
        for (int i = (arrays.length / 2) + 1; i >= 0; i--) {
            maxHeapify(arrays, i, arrays.length);
        }
    }

    /**
     * 维护最大堆
     */
    public static void maxHeapify(int[] array, int i, int length) {

        // 左右子节点在数组中下标
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 根节点和两个子节点中最大的那个元素的下标
        int max = i;
        if (left < length) {
            if (array[left] > array[max]) {
                max = left;
            }
        }
        if (right < length) {
            if (array[right] > array[max]) {
                max = right;
            }
        }

        if (max != i) {
            swap(array, i, max);
            maxHeapify(array, max, length);
        }

    }


    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
