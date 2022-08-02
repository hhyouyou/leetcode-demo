package com.djx.demo.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [剑指 Offer 06]从尾到头打印链表	74.9%	Easy	0.0%
 *
 * @author dongjingxi
 * @date 2022/8/2
 */
public class ReversePrint {

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


        ReversePrint reversePrint = new ReversePrint();
        int[] result = reversePrint.reversePrint(listNode1);

        System.out.println(Arrays.toString(result));
    }

    public int[] reversePrint(ListNode head) {

        ArrayList<Integer> listNodes = new ArrayList<>();

        while (head != null) {

            listNodes.add(head.val);

            head = head.next;
        }

        int[] result = new int[listNodes.size()];

        for (int i = listNodes.size() - 1, j = 0; i >= 0; i--, j++) {
            result[j] = listNodes.get(i);
        }

        return result;
    }


}
