package com.djx.demo.leetcode.nine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 846. 一手顺子
 *
 * @author dongjingxi
 * @date 2022/9/1
 */
public class IsNStraightHand {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            q.add(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            if (map.get(t) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int cnt = map.getOrDefault(t + i, 0);
                if (cnt == 0) {
                    return false;
                }
                map.put(t + i, cnt - 1);
            }
        }

        return true;
    }


}
