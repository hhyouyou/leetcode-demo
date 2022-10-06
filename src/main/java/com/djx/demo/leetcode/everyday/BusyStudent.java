package com.djx.demo.leetcode.everyday;

/**
 * [1450]在既定时间做作业的学生人数
 *
 * @author djx
 * @date 2022/8/19 上午8:31
 */
public class BusyStudent {


    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {

            if (startTime[i] >= queryTime && queryTime <= endTime[i]) {
                count = count + 1;
            }
        }
        return count;
    }


}
