package com.djx.demo.leetcode.random;

/**
 * [11]盛最多水的容器
 *
 * @author dongjingxi
 * @date 2022/8/6
 */
public class MaxArea {


    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        MaxArea maxArea = new MaxArea();

        System.out.println(maxArea.maxArea(height));

    }


    /**
     * 双指针， 如何移动？ 移动小的那个，
     * 因为我们要找到面积最大的，所以尽量保留高的
     */
    public int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0, j = height.length - 1; i <= j; ) {
            int left = height[i];
            int right = height[j];

            int bottom = j - i;
            if (left >= right) {
                maxArea = Math.max(maxArea, right * bottom);
                j--;
            } else {
                maxArea = Math.max(maxArea, left * bottom);
                i++;
            }
        }

        return maxArea;
    }

}
