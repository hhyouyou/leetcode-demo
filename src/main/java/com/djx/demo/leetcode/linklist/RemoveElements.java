package com.djx.demo.leetcode.linklist;

/**
 * [203]移除链表元素
 *
 * @author djx
 * @date 2022/3/18 下午4:41
 */
public class RemoveElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(7, new ListNode(6, new ListNode(7, new ListNode(7))));


        ListNode result = removeElements1(head, 7);
        System.out.println(result);

    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode node = head;

        while (node != null) {

            ListNode nextNode = node.next;
            if (node.val == val) {
                if (nextNode == null) {
                    node = null;
                    break;
                } else {
                    node.val = nextNode.val;
                    node.next = nextNode.next;
                }
            }
            node = node.next;
        }

        return head;
    }

    public static ListNode removeElements1(ListNode head, int val) {

        ListNode node = new ListNode();
        node.next = head;

        while (node.next != null) {
            ListNode nextNode = node.next;
            ListNode nextNextNode = nextNode.next;
            if (nextNode.val == val) {
                if (nextNextNode == null) {
                    node.next = null;
                } else {
                    nextNode.val = nextNextNode.val;
                    nextNode.next = nextNextNode.next;
                }
                continue;
            }
            node = node.next;
        }

        return head;
    }


    public static ListNode removeElements2(ListNode listNode, int val) {

        ListNode head = listNode;

        for (ListNode node = head; node != null; node = node.next) {
            if (node.val == val) {


            }
        }
        return head;
    }

}
