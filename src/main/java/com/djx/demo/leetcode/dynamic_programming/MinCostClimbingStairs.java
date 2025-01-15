package com.djx.demo.leetcode.dynamic_programming;


/**
 * 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
//        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = {10, 15, 20};

        int dynamic = dynamic(cost);
        System.out.println(dynamic);
    }


    public static int dynamic(int[] cost) {
        if (cost.length == 1) return cost[0];

        int step1 = cost[0];
        int step2 = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            int tmp = Math.min(step1, step2) + cost[i];
            step1 = step2;
            step2 = tmp;
        }
        return Math.min(step1, step2);
    }
}
