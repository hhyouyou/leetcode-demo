package com.djx.demo.leetcode.tree;


import java.util.*;
import java.util.stream.IntStream;

/**
 * 二叉树的层序遍历
 *
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

    /**
     * [剑指 Offer 32 - II]从上到下打印二叉树 II
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        setNum(root, result, 0);
        return result;
    }


    /**
     * [剑指 Offer 32 - I]从上到下打印二叉树
     */
    public static int[] levelOrder1(TreeNode root) {
        List<List<Integer>> lists = levelOrder(root);
        return lists.stream().flatMapToInt(list -> list.stream().flatMapToInt(IntStream::of)).toArray();
    }

    /**
     * [剑指 Offer 32 - III]从上到下打印二叉树 III
     */
    public static List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        setNum(root, result, 0);

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(result.get(i));
            }
        }

        return result;
    }


    public static void setNum2(TreeNode root, List<List<Integer>> result, int height) {
        if (Objects.isNull(root)) {
            return;
        }
        if (result.size() <= height) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);

        if (height % 2 == 0) {
            setNum2(root.right, result, height + 1);
            setNum2(root.left, result, height + 1);
        } else {
            setNum2(root.left, result, height + 1);
            setNum2(root.right, result, height + 1);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists.toString());

        int[] array = levelOrder1(root);
        System.out.println(Arrays.toString(array));

        List<List<Integer>> lists1 = levelOrder3(root);
        System.out.println(lists1.toString());

    }
}


