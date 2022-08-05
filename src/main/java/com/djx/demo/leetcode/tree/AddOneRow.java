package com.djx.demo.leetcode.tree;

import java.util.Objects;

/**
 * [623]在二叉树中增加一行
 * <p>
 * <p>
 * 怎么说呢, 这个要增加, 首先就是要先找到, 找到了就知道加在哪里了
 *
 * @author djx
 * @date 2022/8/5 上午10:30
 */
public class AddOneRow {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(5);


        AddOneRow addOneRow = new AddOneRow();
        TreeNode treeNode = addOneRow.addOneRow(root, 1, 1);

        System.out.println(treeNode);


    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }

        nextLevel(root, val, depth, 1);

        return root;
    }


    /**
     * 到下一层找
     */
    public static void nextLevel(TreeNode root, int val, int depth, int height) {
        if (Objects.isNull(root)) {
            return;
        }

        if (depth - 1 == height) {

            TreeNode leftNode = new TreeNode(val);
            leftNode.left = root.left;
            root.left = leftNode;

            TreeNode rightNode = new TreeNode(val);
            rightNode.right = root.right;
            root.right = rightNode;

            return;
        }

        nextLevel(root.left, val, depth, height + 1);
        nextLevel(root.right, val, depth, height + 1);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
