package com.djx.demo.leetcode.sort;

/**
 * @author dong jing xi
 * @date 2021/4/9 0:35
 **/
public class ShellSort {
    public static void main(String[] args) {


    }

    public static void shellSort(int[] array) {
        int length = array.length;
        int temp;
        // 步长
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = array[i];
                int j = i - step;
                while (j >= 0 && array[j] > temp) {
                    array[j + step] = array[j];
                    j -= step;
                }
                array[j + step] = temp;
            }
        }
    }

}
