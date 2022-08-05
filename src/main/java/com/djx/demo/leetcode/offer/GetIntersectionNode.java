package com.djx.demo.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * [剑指 Offer 52]两个链表的第一个公共节点	65.7%	Easy	0.0%
 *
 * @author dongjingxi
 * @date 2022/8/2
 */
public class GetIntersectionNode {


    public static void main(String[] args) {

    }


    ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> listNodes = new HashSet<>();

        while (headA != null) {
            listNodes.add(headA);
            headA = headA.next;
        }


        while (headB != null) {

            if (listNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

}
