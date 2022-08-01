package com.djx.demo.leetcode.offer;

/**
 * ✔	[剑指 Offer 22]链表中倒数第k个节点	80.3%	Easy	0.0%
 *
 * @author dongjingxi
 * @date 2022/8/1
 */
public class GetKthFromEnd {


    public ListNode getKthFromEnd(ListNode head, int k) {
        int length = getListNodeLength(head);

        for (int i = 0; i < length - k; i++) {
            head = head.next;
        }

        return head;
    }


    int getListNodeLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        return getListNodeLength(head.next) + 1;
    }


}

