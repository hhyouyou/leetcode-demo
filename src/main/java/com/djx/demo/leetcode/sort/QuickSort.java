package com.djx.demo.leetcode.sort;

import java.util.Random;

/**
 * @author dong jing xi
 * @date 2021/3/24 17:46
 **/
public class QuickSort {


    public static void main(String[] args) {
        int[] array = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            array[i] = new Random().nextInt(1000000);
        }
//        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();

        quickSort(array, 0, array.length - 1);
//        test(array);
        long time = System.currentTimeMillis() - start;
        System.out.println("end :" + time);
//        System.out.println(Arrays.toString(array));


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
