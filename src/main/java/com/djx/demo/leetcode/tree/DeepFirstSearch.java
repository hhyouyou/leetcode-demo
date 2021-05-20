package com.djx.demo.leetcode.tree;

import java.util.Objects;
import java.util.Stack;

/**
 * @author dong jing xi
 * @date 2021/3/27 16:56
 **/
public class DeepFirstSearch<T> {

    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getLeft().setLeft(new TreeNode<>(4));
        root.getLeft().getLeft().setRight(new TreeNode<>(5));

        DeepFirstSearch<Integer> integerDeepFirstSearch = new DeepFirstSearch<>();
        integerDeepFirstSearch.deepFirstSearchByStack(root);
    }


    public void deepFirstSearch(TreeNode<T> root) {

        if (Objects.isNull(root)) {
            return;
        }

        System.out.println(root.getValue());

        deepFirstSearch(root.getLeft());
        deepFirstSearch(root.getRight());

    }

    public void deepFirstSearchByStack(TreeNode<T> root) {

        Stack<TreeNode<T>> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);

        while (!treeNodeStack.isEmpty()) {
            TreeNode<T> treeNode = treeNodeStack.pop();
            System.out.println(treeNode.getValue());

            if (!Objects.isNull(treeNode.getRight())) {
                treeNodeStack.push(treeNode.getRight());
            }
            if (!Objects.isNull(treeNode.getLeft())) {
                treeNodeStack.push(treeNode.getLeft());
            }

        }

    }


}
