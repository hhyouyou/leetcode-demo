package com.djx.demo.leetcode.struct;

import java.util.Objects;

/**
 * @author dong jing xi
 * @date 2021/3/18 22:41
 **/
public class MyLinkList<E> {

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

    public MyLinkList() {

    }

    public E add(E element) {
        Node<E> newNode = new Node<>(element, null);
        Node<E> oldNode = last;
        last = newNode;
        if (Objects.isNull(oldNode)) {
            head = newNode;
        } else {
            oldNode.next = newNode;
        }

        size++;
        return element;
    }


    public int indexOf(E element) {
        int index = 0;
        if (Objects.isNull(element)) {
            for (Node<E> node = this.head; node != null; node = node.next, index++) {
                if (Objects.isNull(node.value)) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = this.head; node != null; node = node.next, index++) {
                if (element.equals(node.value)) {
                    return index;
                }
            }
        }
        return -1;
    }


    public Node<E> get(int index) {
        if (index < 0 || index > size) {
            // exception
            return null;
        } else {
            Node<E> node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }


    public Node<E> removeLast() {

        return null;
    }

}
