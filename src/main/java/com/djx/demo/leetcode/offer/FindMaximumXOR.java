package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer II 067]最大的异或
 *
 * @author dongjingxi
 * @date 2022/8/16
 */
public class FindMaximumXOR {


    public static void main(String[] args) {
        System.out.println(3 ^ 3);

        int[] nums = {3, 10, 5, 25, 2, 8};
        FindMaximumXOR findMaximumXOR = new FindMaximumXOR();
        System.out.println(findMaximumXOR.findMaximumXOR(nums));

    }


    static class Node {
        Node[] ns = new Node[2];
    }

    Node root = new Node();

    void add(int x) {
        Node p = root;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (p.ns[u] == null) {
                p.ns[u] = new Node();
            }
            p = p.ns[u];
        }
    }

    int getVal(int x) {
        int ans = 0;
        Node p = root;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1, b = 1 - a;
            if (p.ns[b] != null) {
                ans |= (b << i);
                p = p.ns[b];
            } else {
                ans |= (a << i);
                p = p.ns[a];
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            add(i);
            int j = getVal(i);
            ans = Math.max(ans, i ^ j);
        }
        return ans;
    }


}
