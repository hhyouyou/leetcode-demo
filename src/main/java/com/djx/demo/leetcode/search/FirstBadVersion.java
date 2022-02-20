package com.djx.demo.leetcode.search;

/**
 * [278]第一个错误的版本
 * <p>
 * 二分查找
 *
 * @author dongjingxi
 * @date 2022/2/20
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(firstBadVersion(2126753390));
        long time = System.currentTimeMillis() - start;
        System.out.println("耗时 :" + time + "ms");

    }


    public static int firstBadVersion(int n) {
        return (int) binarySearch(0, n - 1, n);
    }


    public static long binarySearch(int start, int end, int n) {

        if (end < start) {
            return -1;
        }
        int mid = start + ((end - start) >> 1);

        if (isBadVersion(mid)) {
            if (mid == 0 || !isBadVersion(mid - 1)) {
                return mid;
            }
            return binarySearch(start, mid - 1, n);
        } else {
            if (isBadVersion(mid + 1)) {
                return mid + 1;
            }
            return binarySearch(mid + 1, end, n);
        }
    }


    public static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

}
