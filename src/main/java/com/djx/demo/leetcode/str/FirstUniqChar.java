package com.djx.demo.leetcode.str;

import java.util.*;

/**
 * @author dong jing xi
 * @date 2020/11/25 13:39
 **/
public class FirstUniqChar {

    public static void main(String[] args) {

    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> charHashMap = new HashMap<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            Integer count = charHashMap.get(chars[i]);
            if (Objects.nonNull(count)) {
                charHashMap.put(chars[i], -1);
            } else {
                charHashMap.put(chars[i], i);
            }
        }
        return charHashMap.values().stream().filter(x -> x != -1).sorted().findFirst().orElse(-1);
    }
}
