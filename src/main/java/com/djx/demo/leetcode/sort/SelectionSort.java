package com.djx.demo.leetcode.sort;

import com.djx.demo.leetcode.util.Utils;

/**
 * @author djx
 * @date 2021/3/26 上午10:49
 */
public class SelectionSort {

    public static void main(String[] args) {

//        Utils.testSort(100000, SelectionSort::selectionSort);
//        Utils.testSort(100000, SelectionSort::selectionSort);
//        Utils.testSort(100000, SelectionSort::selectionSort);
//        Utils.testSort(100000, SelectionSort::selectionSort);
//        Utils.testSort(100000, SelectionSort::selectionSort);
//        Utils.testSort(100000, SelectionSort::selectionSort);
//        Utils.testSort(100000, SelectionSort::selectionSort);
//        Utils.testSort(100000, SelectionSort::selectionSort);
//        Utils.testSort(100000, SelectionSort::selectionSort);
//


        time(100000);
        time(100000);
        time(100000);
        time(100000);
        time(100000);
        time(100000);
        time(100000);
        time(100000);
        time(100000);
        time(100000);
    }

    public static void time(int size) {
        long loading = System.currentTimeMillis();

        int[] randomArray = Utils.getRandomArray(size);

        long randomTime = System.currentTimeMillis() - loading;

        System.out.println("数组大小:" + size + ", randomTime耗时 :" + randomTime + "ms");


        long start = System.currentTimeMillis();

        selectionSort(randomArray);

        long time = System.currentTimeMillis() - start;

        System.out.println("数组大小:" + size + ", 排序耗时 :" + time + "ms");
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
