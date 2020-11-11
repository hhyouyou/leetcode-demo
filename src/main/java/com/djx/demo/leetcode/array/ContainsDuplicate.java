package com.djx.demo.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dong jing xi
 * @date 2020/11/11 14:14
 **/
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }


    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (!numSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
