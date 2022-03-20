package com.djx.demo.leetcode.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * [141]环形链表
 *
 * @author djx
 * @date 2022/3/15 下午2:12
 */
public class HasCycle {

    public static void main(String[] args) {


    }

    public boolean hasCycle(ListNode head) {

        Set<Integer> numSet = new HashSet<>();

        while (head != null) {
            int num = head.val;
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
            head = head.next;
        }
        return false;
    }

}
