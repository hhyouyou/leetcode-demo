package com.djx.demo.leetcode.array;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 692. 前k个高频单词
 *
 * @author djx
 */
class TopKFrequent {


    public static void main(String[] args) {

        ArrayList<String> words = Lists.newArrayList("i", "love", "leetcode", "i", "love", "coding");

        List<String> strings = topKFrequent2(words.toArray(new String[0]), 3);
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

//        // value 倒序
//        Comparator<Map.Entry<String, Integer>> entryComparator = Map.Entry.comparingByValue();
//        // 单词倒序
//        Comparator<Map.Entry<String, Integer>> entryComparator1 = entryComparator.thenComparing((c1, c2) -> c2.getKey().compareTo(c1.getKey()));
        Comparator<Map.Entry<String, Integer>> entryComparator = (c1, c2) -> c1.getValue().equals(c2.getValue())
                ? c2.getKey().compareTo(c1.getKey()) : c1.getValue().compareTo(c2.getValue());

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(entryComparator);
        staticsMap.entrySet().forEach(e -> {
            priorityQueue.add(e);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        });

//        List<String> collect = priorityQueue.stream().map(Map.Entry::getKey).collect(Collectors.toList());
//        Collections.reverse(collect);
//        return collect;
        List<String> ret = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ret.add(priorityQueue.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

    public static List<String> topKFrequent3(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry1.getValue().equals(entry2.getValue()) ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
            }
        });
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

}