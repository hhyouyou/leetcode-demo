package com.djx.demo.leetcode.everyday;

import java.util.Arrays;

/**
 * [1020]飞地的数量
 *
 * @author djx
 * @date 2021/10/14 下午8:42
 */
public class NumEnclaves {

    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}
        };

        int i = numEnclaves(grid);
        System.out.println(i);
    }


    /**
     * 思路, 从边缘开始,对能到达的陆地1 都标 2 , 最后遍历全部,剩下不可达的就是飞地了
     */
    public static int numEnclaves(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {

                    if (grid[i][j] == 1) {
                        fill(grid, i, j);
                        fillAllRound(grid, i, j);
                    }
                }
            }
        }

        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }

        int count = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    count = count + 1;
                }
            }
        }

        return count;
    }


    public static void fillAllRound(int[][] image, int sr, int sc) {

        if (fill(image, sr + 1, sc)) {
            fillAllRound(image, sr + 1, sc);
        }
        if (fill(image, sr - 1, sc)) {
            fillAllRound(image, sr - 1, sc);
        }
        if (fill(image, sr, sc + 1)) {
            fillAllRound(image, sr, sc + 1);
        }
        if (fill(image, sr, sc - 1)) {
            fillAllRound(image, sr, sc - 1);
        }

    }


    public static boolean fill(int[][] image, int sr, int sc) {

        if (sr < 0 || sr >= image.length) {
            return false;
        }
        if (sc < 0 || sc >= image[sr].length) {
            return false;
        }
        if (image[sr][sc] == 1) {
            image[sr][sc] = 2;
            return true;
        }
        return false;

    }
}
