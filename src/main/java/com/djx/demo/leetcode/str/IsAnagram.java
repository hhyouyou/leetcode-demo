package com.djx.demo.leetcode.str;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

/**
 * [242]有效的字母异位词
 *
 * @author djx
 * @date 2021/6/21 下午2:48
 */
public class IsAnagram {

    public static void main(String[] args) {
        boolean anagram = isAnagram("hello", "hlloe3");
        System.out.println(anagram);
    }


    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Byte, Integer> sMap = stringToMap(s);


        byte[] bytes = t.getBytes(StandardCharsets.UTF_8);

        for (byte aByte : bytes) {
            Integer sCount = sMap.get(aByte);
            if (Objects.isNull(sCount)) {
                return false;
            }
            if (--sCount < 0) {
                return false;
            }
            sMap.put(aByte,sCount);

        }

        return true;
    }

    private static HashMap<Byte, Integer> stringToMap(String s) {

        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        HashMap<Byte, Integer> hashMap = new HashMap<>(bytes.length);
        for (byte aByte : bytes) {
            Integer count = hashMap.get(aByte);
            if (Objects.isNull(count)) {
                hashMap.put(aByte, 1);
            } else {
                hashMap.put(aByte, ++count);
            }
        }

        return hashMap;
    }

}
