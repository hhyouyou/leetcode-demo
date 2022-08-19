package com.djx.demo.leetcode.tree;

/**
 * [剑指 Offer 07]重建二叉树
 *
 * @author djx
 * @date 2022/8/19 下午3:38
 */
public class BuildTree {


    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree.buildTree(preorder, inorder);

        System.out.println(treeNode);
    }

    /**
     * preorder 第一位必是根节点
     * inorder  找到根节点, 左边左子树, 右边右子树
     * 递归, 重复上面的步骤
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        // 找到根节点
        // 找到左右子树
        return getRootNode(preorder, 0, inorder, 0, inorder.length - 1);
    }


    private TreeNode getRootNode(int[] preorder, int preRootIndex, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // 新的根节点,
        TreeNode rootNode = new TreeNode(preorder[preRootIndex]);

        int rootIndex = 0;
        for (int i = start; i <= end; i++) {
            if (rootNode.val == inorder[i]) {
                rootIndex = i;
                break;
            }
        }

        // 左子树有几个数字
        int leftCount = (rootIndex - start);

        // 左树的根节点, 必然在
        rootNode.left = getRootNode(preorder, preRootIndex + 1, inorder, start, rootIndex - 1);
        rootNode.right = getRootNode(preorder, preRootIndex + 1 + leftCount, inorder, rootIndex + 1, end);

        return rootNode;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
