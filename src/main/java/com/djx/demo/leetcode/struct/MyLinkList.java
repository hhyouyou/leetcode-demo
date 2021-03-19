package com.djx.demo.leetcode.struct;

/**
 * @author djx
 * @date 2021/3/18 下午3:00
 */
public class MyLinkList<E> {

    public MyLinkList() {
    }

    private int size = 0;
    private Node<E> head;
    private Node<E> last;

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }


    public boolean add(E element) {
        Node<E> newNode = new Node<E>(element, null);
        Node<E> oldNode = this.last;
        last = newNode;

        if (null == oldNode) {
            head = newNode;
        } else {
            oldNode.next = newNode;
        }

        size++;
        return true;
    }

    public E indexOf(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("index: " + index + ", size: " + size);
        }

        Node<E> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }


    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if (index == 0) {
            return pollFirst();
        } else {

            Node<E> deleteNodePrev = this.head;
            for (int i = 0; i < index - 1; i++) {
                deleteNodePrev = deleteNodePrev.next;
            }
            Node<E> deleteNode = deleteNodePrev.next;
            Node<E> deleteNodeNext = deleteNode.next;
            deleteNodePrev.next = deleteNodeNext;

            if (deleteNodeNext == null) {
                last = null;
            }

            E value = deleteNode.value;
            deleteNode.value = null;
            deleteNode.next = null;

            size--;
            return value;
        }

    }


    public E pollFirst() {
        Node<E> node = this.head;
        if (node == null) {
            return null;
        } else {
            E value = node.value;
            head = node.next;

            // help GC
            node.value = null;
            node.next = null;

            if (head == null) {
                last = null;
            }
            size--;
            return value;
        }
    }


}
