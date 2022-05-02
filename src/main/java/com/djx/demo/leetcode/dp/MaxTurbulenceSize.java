package com.djx.demo.leetcode.dp;

/**
 * [978] 最长湍流子数组
 *
 * @author dongjingxi
 * @date 2022/5/1
 */
public class MaxTurbulenceSize {

    public static void main(String[] args) {

        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};

        int max = maxTurbulenceSize(arr);
        System.out.println(max);
    }


    public static int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 2) {
            return arr.length;
        }

        int max = 2;
        int subLength = 2;

        boolean flag = arr[0] < arr[1];
        for (int i = 2; i < arr.length; i++) {
            boolean newFlag = arr[i - 1] < arr[i];
            if (flag != newFlag) {
                subLength = subLength + 1;
            } else {
                subLength = 1;
            }
            flag = newFlag;
            max = Math.max(max, subLength);
        }
        return max;
    }


    public static int maxTurbulenceSize2(int[] arr) {
        if (arr.length <= 2) {
            return arr.length;
        }

        int max = 1;
        int subLength1 = 1;
        int subLength2 = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                subLength1 = subLength2 + 1;
                subLength2 = 1;
            } else if (arr[i - 1] > arr[i]) {
                subLength2 = subLength1 + 1;
                subLength1 = 1;
            } else {
                subLength1 = 1;
                subLength2 = 1;
            }
            max = Math.max(max, Math.max(subLength1, subLength2));
        }
        return max;
    }

}
