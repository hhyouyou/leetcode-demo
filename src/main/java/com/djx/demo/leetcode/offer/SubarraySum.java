package com.djx.demo.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * [剑指 Offer II 010]和为 k 的子数组
 *
 * @author dongjingxi
 * @date 2022/8/22
 */
public class SubarraySum {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println(subarraySum(nums, 3));
        System.out.println(subarraySum1(nums, 3));
        System.out.println(subarraySum2(nums, 3));
    }


    /**
     * 前缀和+ 哈希
     */
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {

            sum = sum + num;

            count = count + map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }


        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static int subarraySum(int[] nums, int k) {

        int count = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum = sum + nums[end];
                if (sum == k) {
                    count = count + 1;
                }
            }

        }

        return count;
    }

}
