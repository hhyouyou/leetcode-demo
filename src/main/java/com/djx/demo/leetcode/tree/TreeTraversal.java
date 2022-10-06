package com.djx.demo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * [144]二叉树的前序遍历
 *
 * @author dongjingxi
 * @date 2022/3/15
 */
public class TreeTraversal {


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2,new TreeNode(3),new TreeNode(4));
        treeNode.right = new TreeNode(5, new TreeNode(6),new TreeNode(7));

//        TreeNode treeNode = new TreeNode(1);
//        treeNode.right = new TreeNode(2, null, new TreeNode(3));

        System.out.println(preorderTraversal(treeNode));
        System.out.println(postorderTraversal(treeNode));
        System.out.println(inorderTraversal(treeNode));

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        setInorderValue(result, root);
        return result;
    }

    public static void setInorderValue(ArrayList<Integer> result, TreeNode root) {
        if (root != null) {
            setInorderValue(result, root.left);
            result.add(root.val);
            setInorderValue(result, root.right);
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        setPostorderValue(result, root);
        return result;
    }

    public static void setPostorderValue(ArrayList<Integer> result, TreeNode root) {
        if (root != null) {
            setPostorderValue(result, root.left);
            setPostorderValue(result, root.right);
            result.add(root.val);
        }
    }

    /**
     * 递归
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        setPreorderValue(result, root);
        return result;
    }

    public static void setPreorderValue(ArrayList<Integer> result, TreeNode root) {
        if (root != null) {
            result.add(root.val);
            setPreorderValue(result, root.left);
            setPreorderValue(result, root.right);
        }
    }

    /**
     * 循环
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        while (root != null) {

            result.add(root.val);

            TreeNode left = root.left;
            TreeNode right = root.right;

        }


        return result;
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
