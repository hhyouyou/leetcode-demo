package com.djx.demo.leetcode.str;

import java.util.Arrays;

/**
 * @author dong jing xi
 * @date 2020/11/18 20:04
 **/
public class ReverseStr {

    public static void main(String[] args) {

        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        System.out.println(Arrays.toString(chars));

    }

    public static void reverseString(char[] s) {
        int length = s.length - 1;
        for (int i = 0; i < (s.length >> 1); i++) {
            char a = s[i];
            s[i] = s[length - i];
            s[length - i] = a;
        }
    }

}
