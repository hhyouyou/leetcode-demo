package com.djx.demo.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * [449]序列化和反序列化二叉搜索树
 *
 * @author dongjingxi
 * @date 2022/5/11
 */
public class SerializeSearchTree {


    public static void main(String[] args) {


        SerializeSearchTree serializeSearchTree = new SerializeSearchTree();

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        treeNode.right = new TreeNode(5, new TreeNode(6), new TreeNode(7));

        System.out.println(serializeSearchTree.serialize(treeNode));
    }


    public String serialize(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        setPostorderValue(result, root);
        return result.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] split = data.split(",");

        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : split) {
            stack.push(Integer.parseInt(s));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
            return null;
        }
        int val = stack.pop();
        TreeNode root = new TreeNode(val);
        root.right = construct(val, upper, stack);
        root.left = construct(lower, val, stack);
        return root;
    }


    public static void setPostorderValue(ArrayList<Integer> result, TreeNode root) {
        if (root != null) {
            setPostorderValue(result, root.left);
            setPostorderValue(result, root.right);
            result.add(root.val);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

