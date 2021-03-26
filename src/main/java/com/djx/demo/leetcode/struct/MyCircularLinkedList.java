package com.djx.demo.leetcode.struct;

/**
 * @author djx
 * @date 2021/3/19 下午5:55
 */
public class MyCircularLinkedList<E> {


    private Node<E> head;
    private Node<E> last;


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


}
