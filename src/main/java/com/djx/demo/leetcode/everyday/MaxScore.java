package com.djx.demo.leetcode.everyday;

/**
 * [1422]分割字符串的最大得分
 *
 * @author dongjingxi
 * @date 2022/8/14
 */
public class MaxScore {

    public static void main(String[] args) {
        int i = maxScore("1111");

        System.out.println(i);
    }


    public static int maxScore(String s) {

        int left = s.charAt(0) == '0' ? 1 : 0;

        int right = 0;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                right = right + 1;
            }
        }

        int max = left + right;


        for (int i = 1; i < s.length() - 1; i++) {
            // left 0,i =  count(0,i-1) + i==0?1:0
            // right i+1, s.length -1  =  count(i, s.length-1) - i==1?1:0

            if (s.charAt(i) == '0') {
                left = left + 1;
            }

            if (s.charAt(i) == '1') {
                right = right - 1;
            }
            max = Math.max(max, left + right);
        }


        return max;
    }


}
