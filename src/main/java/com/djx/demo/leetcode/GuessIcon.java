package com.djx.demo.leetcode;

import java.util.Random;

/**
 * @author djx
 * @date 2022/9/6 上午10:55
 */
public class GuessIcon {


    public static void main(String[] args) {

        Long money = 100L;
        long countZero = 0L;
        long countOne = 0L;

        Random random = new Random();

        while (money > 0) {

            int icon = random.nextInt(2);

            if (icon == 0) {
                money = money + 1;
                countZero = countZero + 1;
            } else {
                money = money - 1;
                countOne = countOne + 1;
            }
            System.out.println(money);
        }

        System.out.println(countZero);
        System.out.println(countOne);

    }


}
