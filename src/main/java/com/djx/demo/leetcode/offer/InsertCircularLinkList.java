package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer II 029]排序的循环链表	34.1%	Medium	0.0%
 *
 * @author dongjingxi
 * @date 2022/8/2
 */
public class InsertCircularLinkList {

    public static void main(String[] args) {

        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node1 = new Node(1);

        node3.next = node4;
        node4.next = node1;
        node1.next = node3;

        InsertCircularLinkList insertCircularLinkList = new InsertCircularLinkList();

        Node insert = insertCircularLinkList.insert(node3, 2);

        System.out.println(insert);

    }


    public Node insert(Node head, int insertVal) {

        Node node = new Node(insertVal);

        if (head == null) {
            node.next = node;
            return node;
        }

        if (head == head.next) {
            head.next = node;
            node.next = head;
            return head;
        }


        Node tmp = head;
        Node tmpNext = head.next;

        while (tmpNext != head) {
            int left = tmp.val;
            int right = tmpNext.val;

            // 单调递增
            if (insertVal >= left && insertVal <= right) {
                break;
            }
            // 反转那个地方
            if (left > right) {
                if (insertVal > left || insertVal < right) {
                    break;
                }
            }
            tmp = tmp.next;
            tmpNext = tmp.next;
        }

        // 如果上面一个都不符合，就直接插在循环的那个节点（主要是上面那个while循环就是在循环节点那边停止的，转圈后的遍历不到）
        tmp.next = node;
        node.next = tmpNext;

        return head;
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
