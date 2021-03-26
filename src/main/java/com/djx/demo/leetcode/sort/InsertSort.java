package com.djx.demo.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author djx
 * @date 2021/3/26 上午11:06
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = new Random().nextInt(100000);
        }
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        insertSort(array);
        long end = System.currentTimeMillis();
        System.out.println("time : " + (end - start));
        System.out.println(Arrays.toString(array));

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
