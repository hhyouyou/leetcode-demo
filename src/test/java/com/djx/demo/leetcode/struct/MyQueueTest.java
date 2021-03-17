package com.djx.demo.leetcode.struct;

import org.junit.jupiter.api.Test;

class MyQueueTest {

    @Test
    void pop() {

        MyQueue<String> stringMyQueue = new MyQueue<String>();
        stringMyQueue.add("e1");
        stringMyQueue.add("e2");
        stringMyQueue.add("e3");
        stringMyQueue.add("e4");
        stringMyQueue.add("e5");
        stringMyQueue.add("e6");

        String pop = stringMyQueue.pop();
        System.out.println(pop);

        pop = stringMyQueue.pop();
        System.out.println(pop);

        pop = stringMyQueue.pop();
        System.out.println(pop);

        pop = stringMyQueue.peek();
        System.out.println(pop);

        pop = stringMyQueue.pop();
        System.out.println(pop);

        pop = stringMyQueue.pop();
        System.out.println(pop);

        pop = stringMyQueue.pop();
        System.out.println(pop);

    }
}