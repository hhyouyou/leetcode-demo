package com.djx.demo.leetcode.dp;

/**
 * [1143]最长公共子序列
 *
 * @author dongjingxi
 * @date 2022/5/3
 */
public class LongestCommonSubsequence {


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                // 如果字符相等， 那么最长公共子序列就是(i-1,j-1)的长度加一
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 不相等， 则取(i-1,j) 和 (i,j-1)的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
