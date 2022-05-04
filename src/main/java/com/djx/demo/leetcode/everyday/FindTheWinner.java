package com.djx.demo.leetcode.everyday;

/**
 * [1823]找出游戏的获胜者
 *
 * @author dongjingxi
 * @date 2022/5/4
 */
public class FindTheWinner {


    public static void main(String[] args) {

        System.out.println(findTheWinner(5, 2));

    }


    public static int findTheWinner(int n, int k) {

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = (k + result - 1) % i + 1;
        }

        return result;
    }
}
