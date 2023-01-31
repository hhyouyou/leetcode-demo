package com.djx.demo.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [剑指 Offer 30]包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * @author dongjingxi
 * @date 2023/1/31
 */
public class MinStack {

    /**
     * ["MinStack","push","push","push","push","min","pop","min","pop","min","pop","min"]
     * [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
     */

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());

    }

    Deque<Node> stack;


    private static class Node {

        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {

        if (stack.isEmpty()) {
            stack.add(new Node(x, x));
        } else {
            stack.add(new Node(x, Math.min(stack.getLast().min, x)));
        }

    }

    public void pop() {
         stack.removeLast();
    }

    public int top() {
        return stack.getLast().val;
    }

    public int min() {
        return stack.getLast().min;
    }
}
