package com.djx.demo.leetcode.linklist;

/**
 * @author djx
 * @date 2022/3/15 下午2:13
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }
}
