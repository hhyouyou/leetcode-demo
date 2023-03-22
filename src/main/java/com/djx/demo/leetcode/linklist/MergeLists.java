package com.djx.demo.leetcode.linklist;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author djx
 * @date 2021/8/16 下午5:17
 */
public class MergeLists {

    /**
     * 1->4->5,
     * 1->3->4,
     * 2->6
     */
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node4 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node5 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node6 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode[] lists = {node1, node2, node3, node4, node5, node6};

        ListNode listNode = mergeLists(lists);
        System.out.println(listNode);

//        ListNode listNode1 = mergeList(new ListNode(1, new ListNode(4, new ListNode(5))), null);
//        System.out.println(listNode1);

    }

    public static ListNode mergeLists(ListNode[] lists) {

        ForkJoinMerge forkJoinMerge = new ForkJoinMerge(lists);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask<ListNode> submit = forkJoinPool.submit(forkJoinMerge);

        try {
            return submit.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class ForkJoinMerge extends RecursiveTask<ListNode> {

        private final ListNode[] lists;

        public ForkJoinMerge(ListNode[] lists) {
            this.lists = lists;
        }

        @Override
        protected ListNode compute() {

            ListNode listNode = new ListNode();
            if (lists.length == 0) {
                return listNode;
            } else if (lists.length == 1) {
                listNode = lists[0];
            } else if (lists.length == 2) {
                // 执行
                listNode = mergeList(lists[0], lists[1]);
            } else {

                int middle = lists.length / 2;
                ForkJoinMerge leftTask = new ForkJoinMerge(Arrays.copyOfRange(lists, 0, middle));
                ForkJoinMerge rightTask = new ForkJoinMerge(Arrays.copyOfRange(lists, middle + 1, lists.length - 1));

                leftTask.fork();
                rightTask.fork();

                listNode = mergeList(leftTask.join(), rightTask.join());
            }
            return listNode;
        }
    }


    public static ListNode mergeList(ListNode one, ListNode two) {

        ListNode node = new ListNode();

        if (one == null && two == null) {
            return node;
        }

        if (one == null) {
            node.val = two.val;
            two = two.next;

            node.next = mergeList(one, two);
            return node;
        }
        if (two == null) {
            node.val = one.val;
            one = one.next;

            node.next = mergeList(one, two);
            return node;
        }

        if (one.val <= two.val) {
            node.val = one.val;
            one = one.next;
        } else {
            node.val = two.val;
            two = two.next;
        }

        node.next = mergeList(one, two);

        return node;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
