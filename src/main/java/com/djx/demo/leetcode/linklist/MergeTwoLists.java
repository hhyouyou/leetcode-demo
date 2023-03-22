package com.djx.demo.leetcode.linklist;

/**
 * [21]合并两个有序链表	66.7%	Easy	0.0%
 *
 * @author djx
 * @date 2022/3/18 下午3:17
 */
public class MergeTwoLists {

    public static void main(String[] args) {


//        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
//        ListNode list2 = new ListNode(0, new ListNode(2, new ListNode(4)));

        ListNode list1 = null;
        ListNode list2 = new ListNode();
        ListNode listNode = mergeTwoLists(list1, list2);

        System.out.println(listNode);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode();

        ListNode head = new ListNode();
        head.next = listNode;

        while (list1 != null || list2 != null) {
            ListNode nextNode = new ListNode();
            if (list1 == null) {
                nextNode = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                nextNode = list1;
                list1 = list1.next;
            } else {
                if (list1.val < list2.val) {
                    nextNode = list1;
                    list1 = list1.next;
                } else {
                    nextNode = list2;
                    list2 = list2.next;
                }
            }

            listNode.next = nextNode;
            listNode = nextNode;
        }

        return head.next.next;
    }
}
