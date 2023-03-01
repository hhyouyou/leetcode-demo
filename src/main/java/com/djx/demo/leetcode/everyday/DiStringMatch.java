package com.djx.demo.leetcode.everyday;

import java.util.Arrays;

/**
 * @author djx
 * @date 2022/5/9 下午9:57
 */
public class DiStringMatch {

    public static void main(String[] args) {

        String s = "IDID";
        int[] ints = diStringMatch(s);

        System.out.println(Arrays.toString(ints));
    }

    public static int[] diStringMatch(String s) {

        int[] result = new int[s.length() + 1];

        int max = s.length();
        int min = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                result[i] = max;
                max = max - 1;
            } else {
                result[i] = min;
                min = min + 1;
            }
        }
        result[s.length()] = max;

        return result;
    }
}
