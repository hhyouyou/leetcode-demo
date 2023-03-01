package com.djx.demo.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * [449]序列化和反序列化二叉搜索树
 * [剑指 Offer 37]序列化二叉树
 *
 * @author dongjingxi
 * @date 2022/8/6
 */
public class SerializeTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5));
        root.right = new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8)));

        SerializeTree serializeTree = new SerializeTree();
        String serialize = serializeTree.serialize(root);

        TreeNode deserialize = serializeTree.deserialize(serialize);

        System.out.println(deserialize);

    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        serialize(result, root);
        return String.join(",", result);
    }

    public static void serialize(ArrayList<String> result, TreeNode root) {
        if (root != null) {
            result.add(String.valueOf(root.val));
            serialize(result, root.left);
            serialize(result, root.right);
        } else {
            result.add("null");
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(split));
        return deserialize(list);
    }

    public TreeNode deserialize(List<String> list) {

        String str = list.get(0);
        if ("null".equals(str)) {
            list.remove(0);
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.parseInt(str));
        list.remove(0);
        treeNode.left = deserialize(list);
        treeNode.right = deserialize(list);

        return treeNode;
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
