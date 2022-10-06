package com.djx.demo.leetcode.tree;

/**
 * [654]最大二叉树
 * <p>
 * 这题有点像昨天碰到的 ， 知道 前序中序， 然后建树的题， 一模一样
 *
 * @author dongjingxi
 * @date 2022/8/20
 */
public class ConstructMaximumBinaryTree {


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getRootNode(nums, 0, nums.length - 1);
    }

    private TreeNode getRootNode(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int root = -1;
        int rootIndex = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > root) {
                root = nums[i];
                rootIndex = i;
            }
        }
        // 新的根节点,
        TreeNode rootNode = new TreeNode(root);

        rootNode.left = getRootNode(nums, start, rootIndex - 1);
        rootNode.right = getRootNode(nums, rootIndex + 1, end);

        return rootNode;
    }


    static class TreeNode {
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
