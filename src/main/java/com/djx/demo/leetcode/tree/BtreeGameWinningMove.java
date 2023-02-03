package com.djx.demo.leetcode.tree;

/**
 * 涂色游戏，　一个节点有上，左，右，三个方向选，吃了一个就堵住路了
 * 所以，只选一次，就能决定胜负
 * 选到的那块数量大于一半以上
 * <p>
 * [1145]二叉树着色游戏
 *
 * @author dongjingxi
 * @date 2023/2/3 上午10:10
 */
public class BtreeGameWinningMove {

    TreeNode xNode;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        find(root, x);

        int leftSize = getSize(xNode.left);

        if (leftSize >= (n + 1) / 2) {
            return true;
        }
        int rightSize = getSize(xNode.right);

        if (rightSize >= (n + 1) / 2) {
            return true;
        }

        if ((n - 1 - leftSize - rightSize) >= (n + 1) / 2) {
            return true;
        }

        return false;
    }

    private int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSize = getSize(node.left);
        int rightSize = getSize(node.right);
        return 1 + leftSize + rightSize;
    }


    public void find(TreeNode node, int x) {
        if (xNode != null || node == null) {
            return;
        }
        if (node.val == x) {
            xNode = node;
            return;
        }
        find(node.left, x);
        find(node.right, x);
    }

    public class TreeNode {
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
