package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;

/**
 * day	[1417]重新格式化字符串
 *
 * @author dongjingxi
 * @date 2022/8/11
 */
public class Reformat {


    public static void main(String[] args) {
        System.out.println(reformat("covid2019"));
    }


    public static String reformat(String s) {

        ArrayList<Character> num = new ArrayList<>();
        ArrayList<Character> letter = new ArrayList<>();


        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num.add(c);
            }

            if (c >= 'a' && c <= 'z') {
                letter.add(c);
            }
        }
        int length = num.size() - letter.size();

        if (length < -1 || length > 1) {
            return "";
        }

        StringBuilder str = new StringBuilder();
        if (num.size() >= letter.size()) {
            for (int i = 0, j = 0; i < num.size() || j < letter.size(); ) {
                if (i < num.size()) {
                    str.append(num.get(i++));
                }
                if (j < letter.size()) {
                    str.append(letter.get(j++));
                }
            }
        }else {
            for (int i = 0, j = 0; i < num.size() || j < letter.size(); ) {
                if (j < letter.size()) {
                    str.append(letter.get(j++));
                }
                if (i < num.size()) {
                    str.append(num.get(i++));
                }
            }
        }


        return str.toString();
    }

}
