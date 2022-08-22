package com.djx.demo.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * [剑指 Offer 24]反转链表
 *
 * @author dongjingxi
 * @date 2022/8/1
 */
public class ReverseList {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ReverseList reverseList = new ReverseList();
        ListNode listNode = reverseList.reverseList1(listNode1);

        System.out.println(listNode);
    }

    /**
     * 不适用额外空间
     */
    public ListNode reverseList1(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public ListNode reverseList(ListNode head) {
        Map<Integer, ListNode> nodeIndexMap = new HashMap<>();

        int index = 0;

        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            nodeIndexMap.put(++index, newNode);
            head = head.next;
        }


        for (int i = index; i > 0; i--) {
            ListNode listNode = nodeIndexMap.get(i);
            listNode.next = nodeIndexMap.getOrDefault(i - 1, null);
        }

        return nodeIndexMap.getOrDefault(index, null);
    }


}
