package com.djx.demo.leetcode.array;

import java.util.Arrays;

/**
 * @author djx
 * @date 2021/7/15 下午8:59
 */
public class FloodFill {


    public static void main(String[] args) {

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(image, 1, 1, 2);

        for (int[] ints : image) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] == newColor) {
            return image;
        }

        int targetColor = image[sr][sc];
        boolean success = fill(image, sr, sc, targetColor, newColor);
        if (success) {
            fillAllRound(image, sr, sc, targetColor, newColor);
        }

        return image;
    }


    public static void fillAllRound(int[][] image, int sr, int sc, int targetColor, int newColor) {

        if (fill(image, sr + 1, sc, targetColor, newColor)) {
            fillAllRound(image, sr + 1, sc, targetColor, newColor);
        }
        if (fill(image, sr - 1, sc, targetColor, newColor)) {
            fillAllRound(image, sr - 1, sc, targetColor, newColor);
        }
        if (fill(image, sr, sc + 1, targetColor, newColor)) {
            fillAllRound(image, sr, sc + 1, targetColor, newColor);
        }
        if (fill(image, sr, sc - 1, targetColor, newColor)) {
            fillAllRound(image, sr, sc - 1, targetColor, newColor);
        }

    }


    public static boolean fill(int[][] image, int sr, int sc, int targetColor, int newColor) {

        if (sr < 0 || sr >= image.length) {
            return false;
        }
        if (sc < 0 || sc >= image[sr].length) {
            return false;
        }
        if (image[sr][sc] == targetColor) {
            image[sr][sc] = newColor;
            return true;
        }
        return false;

    }


}
