package com.djx.demo.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * [剑指 Offer 35]复杂链表的复制	71.6%	Medium	0.0%
 *
 * @author dongjingxi
 * @date 2022/8/1
 */
public class CopyRandomList {


    public Node copyRandomList(Node head) {

        Map<Node, Node> nodeMap = new HashMap<>();

        Node node = head;
        while (head != null) {
            Node newNode = new Node(head.val);
            nodeMap.put(head, newNode);
            head = head.next;
        }

        head = node;

        while (head != null) {

            Node next = head.next;
            Node random = head.random;

            nodeMap.get(head).next = nodeMap.get(next);
            nodeMap.get(head).random = nodeMap.get(random);
            head = head.next;
        }

        return nodeMap.get(node);
    }


}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}