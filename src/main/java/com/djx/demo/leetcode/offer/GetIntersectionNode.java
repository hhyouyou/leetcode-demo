package com.djx.demo.leetcode.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * [剑指 Offer 52]两个链表的第一个公共节点
 *
 * @author dongjingxi
 * @date 2022/8/2
 */
public class GetIntersectionNode {


    public static void main(String[] args) {

    }


    /**
     * 空间复杂度 O(m)
     * 时间复杂度 O(m+n)
     */
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


    /**
     * 空间复杂度 O(m+n)
     * 时间复杂度 O(m+n)
     */
    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        LinkedList<ListNode> stackA = new LinkedList<>();
        LinkedList<ListNode> stackB = new LinkedList<>();

        while (headA != null) {
            stackA.addLast(headA);
            headA = headA.next;
        }


        while (headB != null) {
            stackB.addLast(headB);
            headB = headB.next;
        }

        ListNode result = null;

        while (!stackA.isEmpty() && !stackB.isEmpty()) {

            // 如果不想等 ,说明不是公共节点了, 直接返回
            if (stackA.getLast() != stackB.getLast()) {
                return result;
            }

            // 如果相等, 说明当前节点还是相交的, 记录一下
            result = stackA.getLast();
            stackA.removeLast();
            stackB.removeLast();
        }

        return result;
    }


    /**
     * 优雅!
     * <p>
     * m = a + c
     * n = b + c
     * <p>
     * 指针 pa , pb 分别遍历 headA, headB
     * 当遍历完headA和headB 之后 转为遍历 headB, headA
     * <p>
     * 当两个指针分别走了, a + c + b 以及 b +c + a 之后.
     * 走的距离一样, 所以就会相遇, 所以就碰到了呀
     * <p>
     * 空间复杂度 O(1)
     * 时间复杂度 O(m+n)
     */
    ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != tmpB) {
            tmpA = tmpA == null ? headB : tmpA.next;
            tmpB = tmpB == null ? headA : tmpB.next;
        }

        return tmpA;
    }

}
