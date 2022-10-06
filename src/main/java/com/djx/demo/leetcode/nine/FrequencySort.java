package com.djx.demo.leetcode.nine;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 451 根据字符出现频率排序
 * @author dongjingxi
 * @date 2022/9/1
 */
public class FrequencySort {


    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }


        return map.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(e -> {

                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < e.getValue(); i++) {
                        stringBuilder.append(e.getKey());
                    }
                    return stringBuilder.toString();
                }).collect(Collectors.joining());
    }


}
