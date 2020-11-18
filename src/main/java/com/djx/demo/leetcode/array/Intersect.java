package com.djx.demo.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 相关标签
 * 排序
 * 哈希表
 * 双指针
 * 二分查找
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author dong jing xi
 * @date 2020/11/11 15:01
 **/
public class Intersect {


    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2};
        int[] nums2 = {1, 1};

        int[] intersect = intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));

    }

    // 初次提交版本
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] max = nums2;
        int[] min = nums1;

        if (nums1.length > nums2.length) {
            max = nums1;
            min = nums2;
        }

        HashMap<Integer, Integer> maxMap = new HashMap<>();
        for (int num : max) {
            Integer count = maxMap.get(num);
            if (Objects.isNull(count)) {
                maxMap.put(num, 1);
            } else {
                maxMap.put(num, ++count);
            }
        }

        return Arrays.stream(min).filter(num -> {
            Integer count = maxMap.get(num);
            System.out.println(num + ":" + count);
            if (Objects.isNull(count)) {
                return false;
            } else {
                if (count == 0) {
                    return false;
                } else {
                    maxMap.put(num, count - 1);
                    return true;
                }
            }
        }).toArray();
    }
}
