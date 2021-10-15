package com.djx.demo.leetcode.everyday;

/**
 * [2]两数相加
 *
 * @author djx
 * @date 2021/10/15 上午10:43
 */
public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));

        addTwoNumbers(l1, l2);
    }

    /**
     * 思路:
     * 选一个l1 从头开始和 l2 , 一个节点一个节点相加
     * 结果是  sum%10,  存一个sum/10 加给后一个节点
     * 如果两个节点长短不一了,那就新增节点, 知道 两个链表的 next都为null
     * 如果最后以为两数想加后, > 10了, 那么需要延伸一个节点出来 =1
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }

        ListNode p1 = l1;
        ListNode p2 = l2;

        int jie = 0;

        while (p1 != null || p2 != null) {

            int sum = p1.val + p2.val + jie;

            p1.val = sum % 10;
            jie = sum / 10;

            if (p1.next == null && p2.next == null && jie != 0) {
                p1.next = new ListNode(0);
                p2.next = new ListNode(0);
            }

            if (p1.next == null && p2.next != null) {
                p1.next = new ListNode(0);
            }

            if (p1.next != null && p2.next == null) {
                p2.next = new ListNode(0);
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return l1;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
