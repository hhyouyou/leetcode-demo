package com.djx.demo.leetcode.util;

import java.util.Random;
import java.util.function.Consumer;

/**
 * @author dong jing xi
 * @date 2021/3/26 0:39
 **/
public class Utils {


    public static int[] getRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(10000);
        }
        return array;
    }

    public static void testSort(int[] param, Consumer<int[]> sortConsumer) {

        long start = System.currentTimeMillis();

        sortConsumer.accept(param);

        long time = System.currentTimeMillis() - start;

        System.out.println("耗时 :" + time);
    }

    public static void testSort(int size, Consumer<int[]> sortConsumer) {
        int[] randomArray = getRandomArray(size);

        long start = System.currentTimeMillis();

        sortConsumer.accept(randomArray);

        long time = System.currentTimeMillis() - start;

        System.out.println("数组大小:" + size + ", 耗时 :" + time);
    }


}
