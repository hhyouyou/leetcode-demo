package com.djx.demo.leetcode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author djx
 * @date 2021/2/23 上午9:46
 */
public class LevelOrder {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        setNum(root, result, 0);

        return result;

    }

    public static void setNum(TreeNode root, List<List<Integer>> result, int height) {
        if (Objects.isNull(root)) {
            return;
        }
        if (result.size() <= height) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);

        setNum(root.left, result, height + 1);
        setNum(root.right, result, height + 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists.toString());

    }
}


