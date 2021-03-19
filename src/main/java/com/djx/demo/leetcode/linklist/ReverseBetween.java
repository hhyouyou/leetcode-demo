package com.djx.demo.leetcode.linklist;

//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 681 👎 0


import java.util.Objects;

/**
 * @author djx
 * @date 2021/2/25 上午9:29
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();

        ListNode resultNode = reverseBetween(listNode, 2, 4);


    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode reverse = new ListNode();

        int index = 1;

        while (!Objects.isNull(head.next)) {
            ListNode reverseHead = head;
            ListNode reverseHeadNext = head.next;

            while (index >= left && index <= right) {
                // 开头保存一下
                if (index == left) {
                    reverseHead = head;
                }
                ListNode listNode = new ListNode(head.val);
                listNode.next = reverse;
                reverse = listNode;
                // 结尾 链接 剩余链表，再将其链接回原链表
                if (index == right) {
                    reverse.next = reverseHead.next;
                    head.next = reverse;
                    return head;
                }

                reverseHead = reverseHead.next;
                index++;
            }

            head = head.next;

            index++;
        }
        return head;
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
