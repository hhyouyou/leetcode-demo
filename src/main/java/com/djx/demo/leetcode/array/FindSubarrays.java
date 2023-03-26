package com.djx.demo.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * day	[2395]和相等的子数组	76.2%	Easy	0.0%
 *
 * @author dongjingxi
 * @date 2023/3/26
 */
public class FindSubarrays {


    public boolean findSubarrays(int[] nums) {
        Set<Integer> sumSet = new HashSet<>();

        for (int i = 1; i < nums.length; i++) {
            int sum = nums[i - 1] + nums[i];

            if (sumSet.contains(sum)) {
                return true;
            }
            sumSet.add(sum);
        }

        return false;
    }
}
