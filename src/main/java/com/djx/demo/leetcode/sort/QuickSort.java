package com.djx.demo.leetcode.sort;

import com.djx.demo.leetcode.util.Utils;

/**
 * @author dong jing xi
 * @date 2021/3/24 17:46
 **/
public class QuickSort {


    public static void main(String[] args) {
        Utils.testSort(100000, QuickSort::testTime);
        Utils.testSort(100000, QuickSort::testTime);
        Utils.testSort(100000, QuickSort::testTime);
        Utils.testSort(100000, QuickSort::testTime);
        Utils.testSort(100000, QuickSort::testTime);
        Utils.testSort(100000, QuickSort::testTime);
        Utils.testSort(100000, QuickSort::testTime);

    }

    public static void testTime(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void test(int[] array) {
        int left = 0;
        int right = array.length - 1;

        int minTail = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < array[left]) {
                swap(array, i, ++minTail);
            }
        }
        swap(array, left, minTail);
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
