package com.djx.demo.leetcode.struct;

import org.junit.jupiter.api.Test;

class MyStackTest {

    @Test
    void push() {

        MyStack<String> stringMyStack = new MyStack<>();
        stringMyStack.push("e1");
        stringMyStack.push("e2");
        stringMyStack.push("e3");
        stringMyStack.push("e4");
        stringMyStack.push("e5");
        stringMyStack.push("e6");
        stringMyStack.push("e7");
        stringMyStack.push("e8");
        stringMyStack.push("e9");
        stringMyStack.push("e10");

        String head = stringMyStack.pop();
        System.out.println(head);

        head = stringMyStack.pop();
        System.out.println(head);

        head = stringMyStack.pop();
        System.out.println(head);

        head = stringMyStack.peek();
        System.out.println(head);

        head = stringMyStack.pop();
        System.out.println(head);

        head = stringMyStack.pop();
        System.out.println(head);
    }

}