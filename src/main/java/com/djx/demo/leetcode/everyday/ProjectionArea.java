package com.djx.demo.leetcode.everyday;

import java.util.Arrays;

/**
 * [883]三维形体投影面积 Easy
 *
 * @author dongjingxi
 * @date 2022/4/26
 */
public class ProjectionArea {


    public static void main(String[] args) {

        int[][] grid = {{1, 2}, {3, 4}};

        System.out.println(projectionArea(grid));
    }


    public static int projectionArea(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int bottom = 0;
        int[] left = new int[grid.length];
        int[] right = new int[grid[0].length];


        for (int i = 0; i < grid.length; i++) {


            for (int j = 0; j < grid[i].length; j++) {

                int num = grid[i][j];

                if (num > 0) {
                    bottom = bottom + 1;
                }
                left[i] = Math.max(left[i], num);
                right[j] = Math.max(right[j], num);
            }
        }
        System.out.println(bottom);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i : left) {
            bottom = bottom + i;
        }

        for (int i : right) {
            bottom = bottom + i;
        }

        return bottom;
    }

}
