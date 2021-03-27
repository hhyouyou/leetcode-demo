package com.djx.demo.leetcode.struct;

import org.junit.jupiter.api.Test;

class MyCircularLinkedListTest {

    @Test
    void add() {

        MyCircularLinkedList<String> stringMyCircularLinkedList = new MyCircularLinkedList<>();
        stringMyCircularLinkedList.add("e1");
        stringMyCircularLinkedList.add("e2");
        stringMyCircularLinkedList.add("e3");
        stringMyCircularLinkedList.add("e4");
        System.out.println(stringMyCircularLinkedList);
    }
}