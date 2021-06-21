package com.djx.demo.leetcode.str;

/**
 * @author djx
 * @date 2021/6/21 下午3:23
 */
public class IsPalindrome {

    public static void main(String[] args) {

        boolean palindrome = isPalindrome(" ");
        System.out.println(palindrome);

    }


    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; ) {
            char aChar = chars[i++];

            while (!checkChar(aChar)) {
                if (i == chars.length) {
                    aChar = ' ';
                    break;
                }
                aChar = chars[i++];
            }

            char aChar1 = chars[j--];

            while (!checkChar(aChar1)) {
                if (j < 0) {
                    aChar1 = ' ';
                    break;
                }
                aChar1 = chars[j--];
            }

            if (aChar != aChar1) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkChar(char c) {

        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }

        return false;
    }

}
