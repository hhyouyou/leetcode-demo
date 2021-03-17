package com.djx.demo.leetcode.struct;

/**
 * @author dong jing xi
 * @date 2021/3/17 23:07
 **/
public class MyQueue<E> {

    public MyQueue() {
        last = head = new Node<E>();
    }

    private Node<E> head;

    private Node<E> last;

    static class Node<E> {

        public Node() {

        }

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public E value;
        public Node<E> next;
    }


    public boolean add(E element) {

        last.next = new Node<>(element);
        last = last.next;

        return true;
    }

    public E pop() {
        Node<E> node = head;
        Node<E> first = node.next;
        E result = first.value;
        node.next = node;
        head = first;
        return result;
    }

    public E peek() {
        return head.value;
    }


}
