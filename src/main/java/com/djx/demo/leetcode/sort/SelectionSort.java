package com.djx.demo.leetcode.sort;

import com.djx.demo.leetcode.util.Utils;

/**
 * @author djx
 * @date 2021/3/26 上午10:49
 */
public class SelectionSort {

    public static void main(String[] args) {

        Utils.testSort(100000, SelectionSort::selectionSort);
        Utils.testSort(100000, SelectionSort::selectionSort);
        Utils.testSort(100000, SelectionSort::selectionSort);
        Utils.testSort(100000, SelectionSort::selectionSort);
        Utils.testSort(100000, SelectionSort::selectionSort);
        Utils.testSort(100000, SelectionSort::selectionSort);
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            int min = array[index];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }


    }

}
