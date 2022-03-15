package com.djx.demo.leetcode.everyday;

import java.util.HashMap;

/**
 * [383]赎金信	64.5%	Easy	0.0%
 *
 * @author djx
 * @date 2022/3/15 上午11:06
 */
public class CanConstruct {

    public static void main(String[] args) {

        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> charHashMap = new HashMap<>(magazine.length());

        for (char c : magazine.toCharArray()) {
            Integer times = charHashMap.getOrDefault(c, 0);
            charHashMap.put(c, ++times);
        }

        for (char c : ransomNote.toCharArray()) {
            Integer times = charHashMap.get(c);

            if (times == null || times <= 0) {
                return false;
            }
            charHashMap.put(c, --times);
        }

        return true;
    }

}
