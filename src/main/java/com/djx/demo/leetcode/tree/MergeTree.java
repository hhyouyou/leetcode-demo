package com.djx.demo.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * [1305]两棵二叉搜索树中的所有元素
 *
 * @author dongjingxi
 * @date 2022/5/1
 */
public class MergeTree {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);


        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(0);
        treeNode2.right = new TreeNode(3);


//        List<Integer> allElements = getAllElements(treeNode, treeNode2);
//        System.out.println(allElements);

        List<Integer> integers = getAllElements(treeNode, treeNode2);
        System.out.println(integers);
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> result1 = new ArrayList<>();
        ArrayList<Integer> result2 = new ArrayList<>();
        setPreorderValue(result1, root1);
        setPreorderValue(result2, root2);

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0, j = 0; i < result1.size() || j < result2.size(); ) {

            if (i >= result1.size()) {
                result.add(result2.get(j));
                j++;
                continue;
            }

            if (j >= result2.size()) {
                result.add(result1.get(i));
                i++;
                continue;
            }

            if (result1.get(i) < result2.get(j)) {
                result.add(result1.get(i));
                i++;
            } else {
                result.add(result2.get(j));
                j++;
            }
        }

        return result;
    }

    public static void setPreorderValue(ArrayList<Integer> result, TreeNode node) {
        if (node != null) {
            setPreorderValue(result, node.left);
            result.add(node.val);
            setPreorderValue(result, node.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
