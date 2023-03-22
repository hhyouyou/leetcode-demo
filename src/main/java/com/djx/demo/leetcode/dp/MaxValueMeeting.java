package com.djx.demo.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author djx
 * @date 2022/5/9 下午10:12
 */
public class MaxValueMeeting {


    public static void main(String[] args) {


    }

    public static int maxValue(int[][] events, int k) {


        for (int i = 0; i < events.length; i++) {
            int startTime = events[i][0];
            int endTime = events[i][1];
            int values = events[i][2];
        }


        return 0;
    }


    public static int maxValue1(int[][] events, int k) {

        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        // f[i][j] 代表考虑前 i 个事件，选择不超过 j 的最大价值
        int[][] f = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int[] event = events[i - 1];
            int startTime = event[0], endTime = event[1], value = event[2];

            // 找到第 i 件事件之前，与第 i 件事件不冲突的事件
            // 对于当前事件而言，冲突与否，与 j 无关
            int last = 0;
            for (int p = i - 1; p >= 1; p--) {
                int[] prev = events[p - 1];
                if (prev[1] < startTime) {
                    last = p;
                    break;
                }
            }

            for (int j = 1; j <= k; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[last][j - 1] + value);
            }
        }
        return f[n][k];


    }


}
