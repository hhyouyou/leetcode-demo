package com.djx.demo.leetcode.util;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

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

    public static int[] getRandomArray(int size, int scope) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(scope);
        }
        return array;
    }


    public static void testSort(int[] param, Consumer<int[]> sortConsumer) {

        long start = System.currentTimeMillis();

        sortConsumer.accept(param);

        long time = System.currentTimeMillis() - start;

        System.out.println("数组大小:" + param.length + ", 耗时 :" + time + "ms");
    }

    public static void testSort(int size, Consumer<int[]> sortConsumer) {
        int[] randomArray = getRandomArray(size);

        testSort(randomArray, sortConsumer);
    }

    public static <T, R> R functionRuntime(Function<T, R> function, T t) {
        long start = System.currentTimeMillis();
        R apply = function.apply(t);
        long time = System.currentTimeMillis() - start;
        System.out.println("function:" + function.toString() + ", 耗时 :" + time + "ms");
        return apply;
    }


}
