package com.djx.demo.leetcode.sort;

import com.djx.demo.leetcode.util.Utils;

/**
 * @author dong jing xi
 * @date 2021/3/24 12:44
 **/
public class BubbleSort {

    public static void main(String[] args) {
//        int[] array = {11, 12, 13, 154, 55, 26, 7, 6, 5, 4};
//        bubble3(array);
//        System.out.println(Arrays.toString(array));

        Utils.testSort(10000, BubbleSort::bubble3);
        Utils.testSort(10000, BubbleSort::bubble3);
        Utils.testSort(10000, BubbleSort::bubble3);
        Utils.testSort(10000, BubbleSort::bubble3);
        Utils.testSort(10000, BubbleSort::bubble3);
        Utils.testSort(10000, BubbleSort::bubble3);
        Utils.testSort(10000, BubbleSort::bubble3);
        Utils.testSort(10000, BubbleSort::bubble3);

    }


    public static void bubble(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] < array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // 优化，针对后半部份数据有序
    public static void bubble2(int[] array) {

        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] < array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    // 优化，针对后半部份数据有序
    public static void bubble3(int[] array) {
        int tail = array.length;

        while (tail > 0) {
            int k = tail;
            tail = 0;
            for (int j = 1; j < k; j++) {
                if (array[j - 1] < array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    tail = j;
                }
            }
        }

    }


}
