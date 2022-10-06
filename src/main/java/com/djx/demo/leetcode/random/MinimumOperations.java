package com.djx.demo.leetcode.random;

import java.util.HashSet;

/**
 * [2357]使数组中所有元素都等于零
 * <p>
 * 这个感觉好简单啊, 脑筋急转弯吗?
 * 一开始的想法,还是排序, 然后从最小的非零数开始减
 * 然后发现这个吧, 这个不就是找唯一数字的个数嘛, 就直接上了set集合
 *
 * @author djx
 * @date 2022/8/5 下午3:51
 */
public class MinimumOperations {

    public int minimumOperations(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                numSet.add(num);
            }
        }
        return numSet.size();
    }
}
