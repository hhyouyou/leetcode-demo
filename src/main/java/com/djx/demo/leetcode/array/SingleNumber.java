package com.djx.demo.leetcode.array;

import java.util.HashMap;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 相关标签
 * 位运算
 * 哈希表
 *
 * @author dong jing xi
 * @date 2020/11/11 14:59
 **/
public class SingleNumber {


    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2, 1, 2};
        int i = singleNumber(nums1);
        System.out.println(i);

        System.out.println(nums1.length >> 1);

    }


    // 提交
    public static int singleNumber(int[] nums) {

        HashMap<Integer, Integer> numsHashMap = new HashMap<>((nums.length >> 1) + 1);

        for (int num : nums) {
            if (numsHashMap.containsKey(num)) {
                numsHashMap.remove(num);
            } else {
                numsHashMap.put(num, 0);
            }
        }

        return numsHashMap.keySet().iterator().next();
    }


    // 题解

    public int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
