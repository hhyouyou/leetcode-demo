package com.djx.demo.leetcode.offer;

import java.util.*;

/**
 * [剑指 Offer II 007]数组中和为 0 的三个数
 *
 * @author dongjingxi
 * @date 2022/8/23
 */
public class ThreeSum {


    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

    }

    /**
     * 暴力
     */
    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    /**
     * 双指针
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
