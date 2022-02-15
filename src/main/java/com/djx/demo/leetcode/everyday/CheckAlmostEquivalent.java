package com.djx.demo.leetcode.everyday;

import java.util.HashMap;

/**
 * $ [2067]Number of Equal Count Substrings
 *
 * @author djx
 * @date 2022/2/15 下午1:59
 */
public class CheckAlmostEquivalent {


    public static void main(String[] args) {

        boolean b = checkAlmostEquivalent("aaaa", "bccb");

        System.out.println(b);
    }


    public static boolean checkAlmostEquivalent(String word1, String word2) {

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        HashMap<Character, Integer> countMap = new HashMap<>(chars1.length);

        for (int i = 0; i < chars1.length; i++) {

            Integer count = countMap.getOrDefault(chars1[i], 0);
            count = count + 1;
            countMap.put(chars1[i], count);

            Integer count2 = countMap.getOrDefault(chars2[i], 0);
            count2 = count2 - 1;
            countMap.put(chars2[i], count2);
        }

        for (Integer count : countMap.values()) {
            if (Math.abs(count) > 3) {
                return false;
            }
        }

        return true;
    }

}
