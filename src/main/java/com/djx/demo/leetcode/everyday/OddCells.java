package com.djx.demo.leetcode.everyday;

/**
 *
 * [1252]奇数值单元格的数目
 * @author djx
 * @date 2022/7/12 下午9:18
 */
public class OddCells {


    public int oddCells(int m, int n, int[][] indices) {

        int[] rowArray = new int[m];
        int[] columnArray = new int[n];

        for (int[] index : indices) {
            int row = index[0];
            int column = index[1];

            rowArray[row] = rowArray[row] + 1;
            columnArray[column] = columnArray[column] + 1;

        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = result + ((rowArray[i] + columnArray[j]) % 2);
            }
        }


        return result;
    }


    public static void main(String[] args) {

        int[][] array = {{1,1},{0,0}};

        OddCells oddCells = new OddCells();
        System.out.println(oddCells.oddCells(2, 2, array));


    }
}
