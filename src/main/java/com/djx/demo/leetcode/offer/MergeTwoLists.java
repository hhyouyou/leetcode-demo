package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer 25]合并两个排序的链表	72.7%	Easy	0.0%
 *
 * @author dongjingxi
 * @date 2022/8/1
 */
public class MergeTwoLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);

        ListNode head = new ListNode(0);
        head.next = listNode;

        while (l1 != null || l2 != null) {

            ListNode newNode;

            if (l1 != null && l2 != null) {

                if (l1.val < l2.val) {
                    newNode = l1;
                    l1 = l1.next;
                } else {
                    newNode = l2;
                    l2 = l2.next;
                }

            } else if (l1 == null) {
                newNode = l2;
                l2 = l2.next;
            } else {
                newNode = l1;
                l1 = l1.next;
            }

            listNode.next = newNode;
            listNode = newNode;
        }


        return head.next.next;
    }

}
