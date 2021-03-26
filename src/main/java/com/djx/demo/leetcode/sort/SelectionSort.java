package com.djx.demo.leetcode.sort;

import java.util.Random;

/**
 * @author djx
 * @date 2021/3/26 上午10:49
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = new Random().nextInt(100000);
        }
//        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        selectionSort(array);
        long end = System.currentTimeMillis();
        System.out.println("time : " + (end - start));
//        System.out.println(Arrays.toString(array));

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
