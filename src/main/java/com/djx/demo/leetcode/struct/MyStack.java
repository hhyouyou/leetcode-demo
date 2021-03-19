package com.djx.demo.leetcode.struct;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author dong jing xi
 * @date 2021/3/17 22:25
 **/
public class MyStack<E> {

    private static final int DEFAULT_MAX_SIZE = 4;

    public MyStack() {
        this(DEFAULT_MAX_SIZE);
    }

    public MyStack(int size) {
        this.maxSize = size;
        this.size = 0;
    }

    private Object[] items;
    private int maxSize;
    private int size;

    public E push(E element) {

        if (Objects.isNull(items)) {
            this.items = new Object[maxSize];
        }

        if (size >= maxSize) {
            grow();
        }
        items[size++] = element;
        return element;
    }


    public E pop() {
        E result = null;

        if (size > 0) {
            result = (E) items[size - 1];

            items[size - 1] = null;

            size--;
        }

        return result;
    }

    public E peek() {
        E result = null;
        if (size > 0) {
            result = (E) items[size - 1];
        }
        return result;
    }

    private void grow() {
        maxSize = maxSize << 1;
        items = Arrays.copyOf(items, maxSize);
        System.out.println("grow :" + maxSize);
    }

}
