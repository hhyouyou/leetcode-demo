package com.djx.demo.leetcode.everyday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [73]矩阵置零
 *
 * @author dongjingxi
 * @date 2022/3/14
 */
public class SetZeroes {

    public static void main(String[] args) {

        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//[[0,1,2,0],
// [3,4,5,2],
// [1,3,1,5]]
        setZeroes(matrix);

        System.out.println(Arrays.toString(matrix));

    }

    public static void setZeroes(int[][] matrix) {

        Set<Integer> rowSet = new HashSet<>(matrix.length);
        Set<Integer> lineSet = new HashSet<>(matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    lineSet.add(j);
                }
            }
        }

        for (Integer row : rowSet) {
            Arrays.fill(matrix[row], 0);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (Integer line : lineSet) {
                matrix[i][line] = 0;
            }
        }


    }


}
