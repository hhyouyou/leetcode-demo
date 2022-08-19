package com.djx.demo.leetcode.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [剑指 Offer 03]数组中重复的数字
 *
 * @author djx
 * @date 2022/8/19 下午3:19
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return 0;
    }

    public int findRepeatNumber2(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }
        return 0;
    }


}
