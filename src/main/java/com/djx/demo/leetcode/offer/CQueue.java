package com.djx.demo.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * [剑指 Offer 09]用两个栈实现队列
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 * @author dongjingxi
 * @date 2023/1/31
 */
public class CQueue {


    public static void main(String[] args) {
        CQueue cQueue = new CQueue();

        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    Deque<Integer> first;
    Deque<Integer> second;


    public CQueue() {
        first = new ArrayDeque<>();
        second = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        first.add(value);
    }

    public int deleteHead() {
        if (first.isEmpty()) {
            return -1;
        }
        while (!first.isEmpty()) {
            Integer pop = first.pop();
            second.add(pop);

        }

        Integer head = second.pop();

        while (!second.isEmpty()) {
            first.add(second.pop());
        }

        return head;
    }

}
