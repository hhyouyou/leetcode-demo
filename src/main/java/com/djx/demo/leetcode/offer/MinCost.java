package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer II 091]粉刷房子
 * <p>
 * 动态规划
 *
 * @author dongjingxi
 * @date 2022/8/8
 */
public class MinCost {


    public int minCost(int[][] costs) {

        int[][] dp = new int[costs.length][3];

        dp[0] = new int[3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        return Math.min(Math.min(dp[costs.length - 1][0], dp[costs.length - 1][1]), dp[costs.length - 1][2]);
    }

    public int minCost1(int[][] costs) {

        int[] dp = new int[3];
        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int[] dpTmp = new int[3];

            dpTmp[0] = Math.min(dp[1], dp[2]) + costs[i][0];
            dpTmp[1] = Math.min(dp[0], dp[2]) + costs[i][1];
            dpTmp[2] = Math.min(dp[0], dp[1]) + costs[i][2];

            dp = dpTmp;
        }

        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }


}
