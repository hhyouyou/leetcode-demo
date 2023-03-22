package com.djx.demo.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1838 最高频元素的频数
 *
 * @author djx
 * @date 2021/7/20 下午4:19
 */
public class MaxFrequency {

    public static void main(String[] args) {

        int[] nums = {9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966};

        int i = maxFrequency(nums, 3056);
        System.out.println(i);

    }

    public static int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        int frequency = 1;

        int[] distances = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            int distance = nums[i + 1] - nums[i];
            distances[i] = distance;
        }
        Arrays.sort(distances);

        for (int distance : distances) {
            k = k - distance;
            if (k >= 0) {
                frequency++;
            } else {
                break;
            }
        }

        return frequency;
    }

    public static int maxFrequency1(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int num : nums) {
            Integer count = hashMap.getOrDefault(num, 0);
            count = count + 1;
            hashMap.put(num, count);
        }

        List<Map.Entry<Integer, Integer>> collect = hashMap.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).collect(Collectors.toList());


        return 1;
    }

}
