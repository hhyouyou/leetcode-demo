package com.djx.demo.leetcode;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author dong jing xi
 * @date 2020/10/6 19:44
 **/
public class TwoSum {

    public static void main(String[] args) {
//
//        BigDecimal t = BigDecimal.valueOf(27.982);
//        BigDecimal k = BigDecimal.valueOf(100);
//
//        BigDecimal y0 = BigDecimal.valueOf(28);
//        BigDecimal y1 = y0.subtract(t.divide(k));
//        System.out.println(y1);
//
//        BigDecimal y100 = y0;
//
//        for (int i = 0; i < 100; i++) {
//            y100 = y100.subtract(t.divide(k));
//        }
//
//        System.out.println(y100);
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        HashMap<Integer, Integer> numsIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer index = numsIndex.get(nums[i]);
            if (Objects.nonNull(index)) {
                if (nums[i] + nums[index] == target) {
                    result[0] = i;
                    result[1] = index;
                    return result;
                }
            }
            numsIndex.put(nums[i], i);
        }

        for (Map.Entry<Integer, Integer> entry : numsIndex.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            Integer index = numsIndex.get(target - key);
            if (Objects.nonNull(index)) {
                result[0] = value;
                result[1] = index;
                return result;
            }
        }
        return result;
    }

}
