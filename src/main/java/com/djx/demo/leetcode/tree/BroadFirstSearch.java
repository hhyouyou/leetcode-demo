package com.djx.demo.leetcode.tree;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author dong jing xi
 * @date 2021/3/27 16:56
 **/
public class BroadFirstSearch<T> {


    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getLeft().setLeft(new TreeNode<>(4));
        root.getLeft().getLeft().setRight(new TreeNode<>(5));

        BroadFirstSearch<Integer> integerBroadFirstSearch = new BroadFirstSearch<>();
        integerBroadFirstSearch.broadFirstSearchByQueue(root);
    }

    public void broadFirstSearchByQueue(TreeNode<T> root) {

        LinkedBlockingQueue<TreeNode<T>> queue = new LinkedBlockingQueue<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode<T> treeNode = queue.poll();

            System.out.println(treeNode.getValue());

            if (!Objects.isNull(treeNode.getLeft())) {
                queue.add(treeNode.getLeft());
            }
            if (!Objects.isNull(treeNode.getRight())) {
                queue.add(treeNode.getRight());
            }

        }
    }


}
