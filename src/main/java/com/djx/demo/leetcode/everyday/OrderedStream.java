package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [1656]设计有序流
 *
 * @author dongjingxi
 * @date 2022/8/16
 */
public class OrderedStream {


    public static void main(String[] args) {

        OrderedStream orderedStream = new OrderedStream(5);
        // 插入 (3, "ccccc")，返回 []
        System.out.println(orderedStream.insert(3, "ccccc"));
        // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(orderedStream.insert(1, "aaaaa"));
        // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(orderedStream.insert(2, "bbbbb"));
        // 插入 (5, "eeeee")，返回 []
        System.out.println(orderedStream.insert(5, "eeeee"));
        // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        System.out.println(orderedStream.insert(4, "ddddd"));


    }

    private final Map<Integer, String> map;

    int ptr = 0;

    public OrderedStream(int n) {
        map = new HashMap<>(n);
    }

    public List<String> insert(int idKey, String value) {

        map.put(idKey, value);

        ArrayList<String> result = new ArrayList<>();
        while (map.containsKey(ptr + 1)) {
            result.add(map.get(ptr + 1));
            ptr = ptr + 1;
        }
        return result;
    }

}
