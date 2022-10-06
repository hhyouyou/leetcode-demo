package com.djx.demo.leetcode.array;

/**
 * [121]买卖股票的最佳时机
 *
 * @author dongjingxi
 * @date 2022/3/10
 */
public class MaxProfit1 {


    public static void main(String[] args) {

        int[] num = {7,6,4,3,1};

        int i = maxProfit(num);
        System.out.println(i);

    }

    public static int maxProfit(int[] prices) {

        int min = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);

            min = Math.min(min, prices[i]);
        }

        return max;
    }

}
