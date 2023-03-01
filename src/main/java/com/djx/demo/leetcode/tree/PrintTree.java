package com.djx.demo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * [655]输出二叉树
 *
 * @author djx
 * @date 2022/8/22 上午10:00
 */
public class PrintTree {


    public static void main(String[] args) {
        PrintTree printTree = new PrintTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);


        List<List<String>> lists = printTree.printTree(root);
        System.out.println(lists.toString());
    }


    private int maxHeight = 0;

    /**
     * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
     * 矩阵的列数 n 应该等于 2height+1 - 1 。
     * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
     * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
     * 继续这一过程，直到树中的所有节点都妥善放置。
     * 任意空单元格都应该包含空字符串 ""
     */
    public List<List<String>> printTree(TreeNode root) {

        // 获取高度
        getHeight(root, 0);
        int m = maxHeight + 1;
        int n = (int) (Math.pow(2, maxHeight + 1) - 1);

        // 组装
        List<List<String>> result = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<String> strings = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                strings.add("");
            }
            result.add(strings);
        }

        setNode(root, result, 0, (n - 1) / 2);
        return result;
    }


    public void setNode(TreeNode root, List<List<String>> result, int row, int column) {

        if (root == null) {
            return;
        }

        result.get(row).set(column, String.valueOf(root.val));
        int offset = (int) (Math.pow(2, maxHeight - row - 1));
        setNode(root.left, result, row + 1, column - offset);
        setNode(root.right, result, row + 1, column + offset);

    }

    public void getHeight(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        maxHeight = Math.max(maxHeight, height);
        getHeight(root.left, height + 1);
        getHeight(root.right, height + 1);
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
