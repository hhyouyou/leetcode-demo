package com.djx.demo.leetcode.offer;

/**
 * [剑指 Offer II 009]乘积小于 K 的子数组
 * 滑动窗口
 *
 * @author dongjingxi
 * @date 2022/8/22
 */
public class NumSubarrayProductLessThanK {


    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(numSubarrayProductLessThanK(nums, 0));
    }

    /**
     * 利用 1 <= nums[i] <= 1000，我们可以从前往后处理所有的 nums[i]，使用一个变量 cur 记录当前窗口的乘积，使用两个变量 j 和 i 分别代表当前窗口的左右端点。
     * <p>
     * 当 cur >= k 时，我们考虑将左端点 j 右移，同时消除原来左端点元素 nums[j] 对 cur 的贡献，直到 cur >= k 不再满足，
     * 这样我们就可以得到每个右端点 nums[i] 的最远左端点 nums[j]，从而得知以 nums[i] 为结尾（固定右端点）的合法子数组个数（左端点个数）为 i - j + 1。
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int count = 0;

        int result = 1;
        int left = 0;
        int right = 0;

        for (; right < nums.length; right++) {

            result = result * nums[right];
            while (result >= k) {
                result = result / nums[left];
                left = left + 1;
            }
            count = count + right - left + 1;
        }

        return count;
    }


}
