package com.djx.demo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * day	[1260]二维网格迁移
 * <p>
 * <p>
 * m ==grid.length
 * n ==grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 *
 * @author dongjingxi
 * @date 2022/7/20
 */
public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> result = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }



        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int num = grid[i][j];

                // 移动多少行
                int row = (i + ((j + k) / n)) % m;
                // 移动多少列
                int column = (j + k) % n;

                result.get(row).set(column, num);

            }
        }


        return result;
    }


    public static void main(String[] args) {

        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        int k = 7;

        ShiftGrid shiftGrid = new ShiftGrid();

        List<List<Integer>> lists = shiftGrid.shiftGrid(grid, k);

        System.out.println(lists);
    }

}
