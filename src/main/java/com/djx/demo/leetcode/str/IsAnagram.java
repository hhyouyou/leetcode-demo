package com.djx.demo.leetcode.str;

import org.apache.commons.collections.CollectionUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author djx
 * @date 2021/6/21 下午2:48
 */
public class IsAnagram {

    public static void main(String[] args) {
        boolean anagram = isAnagram("hello", "hlloe");
        System.out.println(anagram);
    }


    public static boolean isAnagram(String s, String t) {

        HashMap<Byte, Integer> sMap = stringToMap(s);
        HashMap<Byte, Integer> tMap = stringToMap(t);

        if (sMap.size() != tMap.size()) {
            return false;
        }

        if (!CollectionUtils.isEqualCollection(sMap.keySet(), tMap.keySet())) {
            return false;
        }

        for (Byte aByte : sMap.keySet()) {
            Integer sCount = sMap.get(aByte);
            Integer tCount = tMap.get(aByte);
            if (Objects.isNull(tCount)){
                return false;
            }

            if (!sCount.equals(tCount)) {
                return false;
            }
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
