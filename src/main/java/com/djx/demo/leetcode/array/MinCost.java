package com.djx.demo.leetcode.array;


/**
 * [1578]避免重复字母的最小删除成本
 *
 * @author djx
 * @date 2021/8/16 下午3:50
 */
public class MinCost {

    public static void main(String[] args) {

        String s = "aaaabbccccc";
        int[] cost = {10, 1, 10, 1, 1, 2, 1, 3, 1, 2, 1};
        int costSum = minCost(s, cost);
        System.out.println(costSum);

    }

    public static int minCost(String s, int[] cost) {
        int costSum = 0;

        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length - 1; i++) {
            int endIndex = i;
            for (int j = i + 1; j < bytes.length; j++) {
                if (bytes[i] == bytes[j]) {
                    endIndex = j;
                } else {
                    break;
                }
            }
            if (endIndex != i) {
                int max = 0;
                for (int k = i; k <= endIndex; k++) {
                    max = Math.max(max, cost[k]);
                    costSum = costSum + cost[k];
                }
                costSum = costSum - max;
            }
            i = endIndex;
        }

        return costSum;
    }
}
