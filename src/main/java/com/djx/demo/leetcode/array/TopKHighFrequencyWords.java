package com.djx.demo.leetcode.array;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

class TopKHighFrequencyWords {


    public static void main(String[] args) {

        ArrayList<String> words = Lists.newArrayList("a", "aa", "aaa");

        List<String> strings = topKFrequent2(words.toArray(new String[0]), 2);
        System.out.println(strings.toString());

    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> staticsMap = new HashMap<>(words.length);

        for (String word : words) {
            Integer count = staticsMap.getOrDefault(word, 0);
            staticsMap.put(word, ++count);
        }

        // value 倒序
        Comparator<Map.Entry<String, Integer>> entryComparator = (c1, c2) -> c2.getValue().compareTo(c1.getValue());
        // 单词倒序
        Comparator<Map.Entry<String, Integer>> entryComparator1 = entryComparator.thenComparing(Map.Entry::getKey);
        return staticsMap.entrySet().stream()
                .sorted(entryComparator1)
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }

    // TODO: 2021/5/20  bug
    public static List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> staticsMap = new HashMap<>(words.length);

        for (String word : words) {
            Integer count = staticsMap.getOrDefault(word, 0);
            staticsMap.put(word, ++count);
        }

        // value 倒序
        Comparator<Map.Entry<String, Integer>> entryComparator = (c1, c2) -> c2.getValue().compareTo(c1.getValue());
        // 单词倒序
        Comparator<Map.Entry<String, Integer>> entryComparator1 = entryComparator.thenComparing(Map.Entry::getKey);
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(entryComparator1);
        priorityQueue.addAll(staticsMap.entrySet());

        return priorityQueue.stream().map(Map.Entry::getKey).limit(k).collect(Collectors.toList());
    }
}