package com.djx.demo.leetcode.array;

/**
 * ✔[566]重塑矩阵
 * @author djx
 * @date 2021/12/24 下午4:01
 */
public class MatrixReshape {

    public static void main(String[] args) {

        int m = 4;
        int n = 4;

        int[][] mat = createArray(n);

        int[][] result = matrixReshape(mat, 2, 8);

        System.out.println(result);

    }

    private static int[][] createArray(int n) {
        int[][] result = new int[4][4];

        for (int i = 0; i < 16; i++) {
            addResult(result, i, i, n);
        }
        return result;
    }


    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];

        for (int i = 0, k = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++, k++) {
                result[k / c][k % c] = mat[i][j];
            }
        }
        return result;
    }

    private static void addResult(int[][] result, int num, int k, int c) {
        result[k / c][k % c] = num;
    }


}
