package com.djx.demo.leetcode.everyday;

/**
 * [121]买卖股票的最佳时机
 *
 * @author dongjingxi
 * @date 2022/3/10
 */
public class MaxProfit1 {


    public static void main(String[] args) {

        int[] num = {2,4,1};

        int i = maxProfit(num);
        System.out.println(i);

    }

    public static int maxProfit(int[] prices) {

        int min = prices[0];
        int minIndex = 0;

        for (int i = 1; i < prices.length; i++) {

            if (min > prices[i]) {
                min = prices[i];
                minIndex = i;
            }
        }

        int max = prices[minIndex];

        for (int i = minIndex; i < prices.length; i++) {

            max = Math.max(max, prices[i]);

        }

        return max - min;
    }

}
