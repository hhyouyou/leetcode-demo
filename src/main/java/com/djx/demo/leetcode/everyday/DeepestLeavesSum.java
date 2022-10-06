package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * [1302]层数最深叶子节点的和
 * <p>
 * <p>
 * 这题应该是， 之前做的 二叉树层级遍历的变种题
 * 只要找到最深的层， 然后把最后一层的值求和即可
 *
 * @author dongjingxi
 * @date 2022/8/17
 */
public class DeepestLeavesSum {


    public static void main(String[] args) {
        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5));
        root.right = new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8)));


        int result = deepestLeavesSum.deepestLeavesSum(root);

        System.out.println(result);
    }


    public int deepestLeavesSum(TreeNode root) {
        List<List<Integer>> treeLevel = new ArrayList<>();
        setNum(root, treeLevel, 0);
        return treeLevel.get(treeLevel.size() - 1).stream().reduce(Integer::sum).orElse(0);
    }


    public void setNum(TreeNode root, List<List<Integer>> treeLevel, int height) {

        if (root == null) {
            return;
        }

        if (treeLevel.size() <= height) {
            treeLevel.add(new ArrayList<>());
        }
        treeLevel.get(height).add(root.val);

        setNum(root.left, treeLevel, height + 1);
        setNum(root.right, treeLevel, height + 1);

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
