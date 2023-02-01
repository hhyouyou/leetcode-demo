package com.djx.demo.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * [剑指 Offer 35]复杂链表的复制
 *
 * @author dongjingxi
 * @date 2022/8/1
 */
public class CopyRandomList {


    /**
     * 方法二 原地复制
     */
    public Node copyRandomList2(Node head) {

        if (head == null) {
            return null;
        }

        // 在每个节点后面插一个新的
        Node tmp = head;
        while (head != null) {
            Node newNode = new Node(head.val);
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
        }

        head = tmp;
        while (head != null) {
            if (head.random != null) {
                // head.random = head的random指向的节点
                // head.random.next = head的random指向的节点后面跟的那个新节点
                head.next.random = head.random.next;
            }
            // 跳着走，只走原节点
            head = head.next.next;
        }

        // 剪除原节点
        head = tmp;
        Node result = head.next;
        while (head != null) {
            Node next = head.next;
            if (next != null) {
                head.next =next.next;
            }
            head = next;
        }
        return result;
    }


    public Node copyRandomList(Node head) {

        Map<Node, Node> nodeMap = new HashMap<>();
        // 建立节点
        Node node = head;
        while (head != null) {
            Node newNode = new Node(head.val);
            nodeMap.put(head, newNode);
            head = head.next;
        }

        head = node;

        // 建立引用关系
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
