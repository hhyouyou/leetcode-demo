package com.djx.demo.leetcode.tree;

/**
 *
 * [剑指 Offer 26]树的子结构
 * @author dongjingxi
 * @date 2023/2/8
 */
public class IsSubStructure {

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

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }


        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    public boolean recur(TreeNode A, TreeNode B) {

        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }


        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
