package com.djx.demo.leetcode.everyday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * [442]数组中重复的数据
 *
 * @author dongjingxi
 * @date 2022/5/8
 */
public class FindDuplicates {

    public static void main(String[] args) {


    }


    public static List<Integer> findDuplicates(int[] nums) {

        HashMap<Integer, Integer> numMap = new HashMap<>(nums.length);

        for (int num : nums) {
            Integer count = numMap.getOrDefault(num, 0);
            numMap.put(num, count + 1);
        }

        return numMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
