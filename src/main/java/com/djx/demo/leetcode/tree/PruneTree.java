package com.djx.demo.leetcode.tree;


/**
 * [814]二叉树剪枝	72.6%	Medium	0.0%
 *
 * @author dongjingxi
 * @date 2022/7/28
 */
public class PruneTree {


    public TreeNode pruneTree(TreeNode root) {
        if (allZero(root)) {
            return null;
        }
        return root;
    }


    public boolean allZero(TreeNode node) {

        TreeNode left = node.left;
        TreeNode right = node.right;

        // 左子树是否都是0 ， 是的话，直接置空
        if (left != null && allZero(left)) {
            node.left = null;
        }

        // 右子树是否都是0 ， 是的话，直接置空
        if (right != null && allZero(right)) {
            node.right = null;
        }


        // 值为0 ， 左右都是null（如果是zero在上面都被置null了） 则是全零
        return node.val == 0 && node.left == null && node.right == null;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(0, new TreeNode(0), new TreeNode(0));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(1));

        PruneTree pruneTree = new PruneTree();
        TreeNode treeNode = pruneTree.pruneTree(root);


        System.out.println(treeNode);
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
