package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer 22]链表中倒数第k个节点
 *
 * @author dongjingxi
 * @date 2022/8/1
 */
public class GetKthFromEnd {

    /**
     * 快慢指针
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {

        ListNode fast = head;
        ListNode slow = head;


        while (fast != null && k > 0) {
            fast = fast.next;
            k = k - 1;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    /**
     * 差值法
     */
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

