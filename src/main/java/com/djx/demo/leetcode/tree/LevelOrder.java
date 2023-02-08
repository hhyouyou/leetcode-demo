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
     * bfs
     */
    public static List<List<Integer>> levelOrder5(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }

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
     * 方法二，广度优先搜索bfs
     */
    public static int[] levelOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            result.add(pop.val);
            if (pop.left != null) {
                queue.add(pop.left);
            }
            if (pop.right != null) {
                queue.add(pop.right);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
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

    /**
     * bfs
     */
    public static List<List<Integer>> levelOrder6(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isLeft = true;

        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isLeft) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
            isLeft = !isLeft;
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

        lists = levelOrder5(root);
        System.out.println(lists.toString());

        int[] array = levelOrder1(root);
        System.out.println(Arrays.toString(array));

        array = levelOrder2(root);
        System.out.println(Arrays.toString(array));

        List<List<Integer>> lists1 = levelOrder3(root);
        System.out.println(lists1.toString());

        lists1 = levelOrder6(root);
        System.out.println(lists1.toString());


    }
}


