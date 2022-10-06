package com.djx.demo.leetcode.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [剑指 Offer II 114]外星文字典
 *
 * @author dongjingxi
 * @date 2022/8/7
 */
public class AlienOrder {

    public static void main(String[] args) {

    }


    static final int visiting = 1;
    static final int visited = 2;

    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> states = new HashMap<>();
    boolean valid = true;
    char[] order;
    int index;


    public String alienOrder(String[] words) {

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                edges.putIfAbsent(c, new ArrayList<>());
            }
        }

        // 添加边
        for (int i = 1; i < words.length && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }

        order = new char[edges.size()];
        index = edges.size() - 1;
        for (Character u : edges.keySet()) {
            // 未搜索到当前字符u
            if (!states.containsKey(u)) {
                dfs(u);
            }
        }

        // 非法
        if (!valid) {
            return "";
        }

        return new String(order);
    }

    private void dfs(Character u) {
        // 正在搜索中
        states.put(u, visiting);

        // 边
        List<Character> vList = edges.get(u);

        for (Character v : vList) {
            // 没处理过
            if (!states.containsKey(v)) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (states.get(v) == visiting) {
                // 在访问中(说明环了)
                valid = false;
                return;
            }
        }
        states.put(u, visited);
        order[index] = u;
        index--;
    }

    private void addEdge(String before, String after) {

        int length = Math.min(before.length(), after.length());

        int index = 0;

        while (index < length) {
            char c1 = before.charAt(index);
            char c2 = after.charAt(index);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                break;
            }
            index++;
        }
        // 如果 两个字符串前面的部分一样， 而且前面的比后面的长
        // 说明是非法的
        if (index == length && before.length() > after.length()) {
            valid = false;
        }


    }
}
