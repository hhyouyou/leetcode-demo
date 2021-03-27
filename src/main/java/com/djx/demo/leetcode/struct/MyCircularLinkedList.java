package com.djx.demo.leetcode.struct;

/**
 * @author dong jing xi
 * @date 2021/3/19 22:56
 **/
public class MyCircularLinkedList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;

    private int size = 0;

    private Node<E> head;
    private Node<E> last;


    public MyCircularLinkedList() {

    }

    public int getSize() {
        return size;
    }

    static class Node<E> {

        public Node() {

        }

        public Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public E value;
        public Node<E> prev;
        public Node<E> next;
    }

    public boolean add(E element) {

        Node<E> newNode = new Node<>(element, null, null);
        Node<E> lastNode = this.last;
        Node<E> headNode = this.head;

        last = newNode;
        newNode.prev = lastNode;
        newNode.next = headNode;
        if (lastNode == null) {
            head = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            lastNode.next = newNode;
        }

        size++;
        return true;
    }


}