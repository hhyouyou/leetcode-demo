package com.djx.demo.leetcode.everyday;

import java.util.*;

/**
 * [398]随机数索引
 *
 * @author djx
 * @date 2022/4/25 上午10:11
 */
public class RandomPick {

    private final Map<Integer, List<Integer>> numsMap = new HashMap<>();
    private Random random;

    public RandomPick(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexList = numsMap.getOrDefault(nums[i], new ArrayList<>());
            indexList.add(i);
            numsMap.put(nums[i], indexList);
        }
    }

    public int pick(int target) {
        List<Integer> indexList = numsMap.get(target);
        return indexList.get(random.nextInt(indexList.size()));
    }
}
