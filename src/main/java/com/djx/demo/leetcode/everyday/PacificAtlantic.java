package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * [417]太平洋大西洋水流问题 Medium
 *
 * @author djx
 * @date 2022/4/27 上午10:54
 */
public class PacificAtlantic {

    public static void main(String[] args) {
//
//        int[][] heights = {
//                {1, 2, 2, 3, 5},
//                {3, 2, 3, 4, 4},
//                {2, 4, 5, 3, 1},
//                {6, 7, 1, 4, 5},
//                {5, 1, 1, 2, 4}
//        };

        int[][] heights = {
                {10, 10, 10},
                {10, 1, 10},
                {10, 10, 10}
        };

        List<List<Integer>> lists = pacificAtlantic(heights);
        System.out.println(lists);
    }

    /**
     * 方法一
     * 两次遍历,
     * 一次从左边和上边开始, 标记能流下去的加上 01
     * 一次从右边和下边开始, 标记能流下去的加上 10 (如果已经被标记过的,记录)
     * 最后遍历结果为 11 的坐标
     * <p>
     * <p>
     * 不行,这么遍历的话,如果涉及到, 先往左流在往上流的,就会检测不到
     */
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        int[][] result = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            int[] row = heights[i];
            for (int j = 0; j < row.length; j++) {
                int height = heights[i][j];
                if (i == 0 || j == 0) {
                    result[i][j] = 1;
                } else {
                    if ((height >= heights[i - 1][j] || height >= heights[i][j - 1])
                            & (result[i - 1][j] == 1 || result[i][j - 1] == 1)) {
                        result[i][j] = 1;
                    }
                }
            }
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            int[] row = heights[i];
            for (int j = row.length - 1; j >= 0; j--) {
                int height = heights[i][j];
                if (i == heights.length - 1 || j == row.length - 1) {
                    if (result[i][j] > 0) {
                        result[i][j] = 3;
                    } else {
                        result[i][j] = 2;
                    }
                } else {
                    if ((height >= heights[i + 1][j] || height >= heights[i][j + 1])
                            & (result[i + 1][j] >= 2 || result[i][j + 1] >= 2)) {
                        if (result[i][j] > 0) {
                            result[i][j] = 3;
                        } else {
                            result[i][j] = 2;
                        }
                    }
                }
            }
        }

        List<List<Integer>> resultList = new ArrayList<>();
//        for (int[] intArray : result) {
//            System.out.println(Arrays.toString(intArray));
//        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] == 3) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(i);
                    integers.add(j);
                    resultList.add(integers);
                }
            }
        }


        return resultList;
    }
}
