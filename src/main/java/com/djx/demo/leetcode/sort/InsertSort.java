package com.djx.demo.leetcode.sort;

import com.djx.demo.leetcode.util.Utils;

/**
 * @author djx
 * @date 2021/3/26 上午11:06
 */
public class InsertSort {

    public static void main(String[] args) {

        Utils.testSort(100000, InsertSort::insertSort);
        Utils.testSort(100000, InsertSort::insertSort);
        Utils.testSort(100000, InsertSort::insertSort);
        Utils.testSort(100000, InsertSort::insertSort);
        Utils.testSort(100000, InsertSort::insertSort);
        Utils.testSort(100000, InsertSort::insertSort);
        Utils.testSort(100000, InsertSort::insertSort);

    }

    public static void insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            if (j != i) {
                array[j] = temp;
            }
        }


    }

}
