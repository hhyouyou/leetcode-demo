package com.djx.demo.leetcode.everyday;

/**
 * [1475]商品折扣后的最终价格
 *
 * @author dongjingxi
 * @date 2022/9/1
 */
public class FinalPrices {


    public int[] finalPrices(int[] prices) {

        for (int i = 0; i < prices.length; i++) {

            int price = prices[i];

            for (int j = i + 1; j < prices.length; j++) {

                int discount = prices[j];
                if (discount <= price) {
                    price = price - discount;
                    break;
                }

            }

            prices[i] = price;
        }


        return prices;

    }

}
