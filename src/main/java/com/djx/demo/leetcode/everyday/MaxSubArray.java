package com.djx.demo.leetcode.everyday;

/**
 * [53]最大子数组和
 * @author dongjingxi
 * @date 2022/3/7
 */
public class MaxSubArray {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,-2,3,-9,10};

//        int[] ints = Arrays.copyOfRange(nums, 0, 2);

        System.out.println(maxSubArray2(nums));


    }

    public static int maxSubArray(int[] nums) {

        int max = nums[0];
        int pre = 0;

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }

        return max;
    }


    public static int maxSubArray2(int[] nums) {
        return getStatus(nums, 0, nums.length - 1).mSum;
    }

    public static Status getStatus(int[] nums, int l, int r) {

        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }

        int m = (l + r) / 2;

        Status lStatus = getStatus(nums, l, m);
        Status rStatus = getStatus(nums, m + 1, r);

        return mergeStatus(lStatus, rStatus);
    }

    private static Status mergeStatus(Status lStatus, Status rStatus) {
        int iSum = lStatus.iSum + rStatus.iSum;
        int lSum = Math.max(lStatus.lSum, lStatus.iSum + rStatus.lSum);
        int rSum = Math.max(lStatus.rSum + rStatus.iSum, rStatus.rSum);
        int mSum = Math.max(Math.max(lStatus.mSum, rStatus.mSum), lStatus.rSum + rStatus.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }


    public static class Status {

        public int lSum;
        public int rSum;
        public int mSum;
        public int iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }


}
