package com.djx.demo.leetcode.everyday;

/**
 * [292]Nim 游戏
 *
 * @author djx
 * @date 2021/10/14 下午9:08
 */
public class CanWinNim {

    public static void main(String[] args) {

        System.out.println(canWinNim(1));
    }

    /**
     * 先手 后手
     * 1    赢
     * 2    赢
     * 3    赢
     * 4        赢
     * 5    赢
     * 6    赢
     * 7    赢
     * 8        赢
     * .
     * .
     * .
     * <p>
     * 所以啊 4的倍数赢不了啊
     */
    public static boolean canWinNim(int n) {

        return (n % 4 != 0);
    }
}
