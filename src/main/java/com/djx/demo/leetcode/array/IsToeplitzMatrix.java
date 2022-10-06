package com.djx.demo.leetcode.array;

/**
 * @author djx
 * @date 2022/4/22 上午10:21
 */
public class IsToeplitzMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};

        System.out.println(isToeplitzMatrix(matrix));

    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 1 || matrix[0].length == 1) {
            return true;
        }

        for (int i = 1; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 1; j < row.length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
