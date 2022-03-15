package com.djx.demo.leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * [36]有效的数独
 *
 * @author dongjingxi
 * @date 2022/3/14
 */
public class ValidSudoku {

    public static void main(String[] args) {

        System.out.println(isValidSudoku(createArray()));

    }

    private static char[][] createArray() {
        char[][] result = new char[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = ' ';
            }
        }
        return result;
    }

    public static boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>(8);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }

            set = new HashSet<>(8);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    } else {
                        set.add(board[j][i]);
                    }
                }
            }

            set = new HashSet<>(8);
            int row = i / 3 * 3;
            int line = i % 3 * 3;
            for (int j = row; j < row + 3; j++) {
                for (int k = line; k < line + 3; k++) {
                    if (board[j][k] != '.') {
                        if (set.contains(board[j][k])) {
                            return false;
                        } else {
                            set.add(board[j][k]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
