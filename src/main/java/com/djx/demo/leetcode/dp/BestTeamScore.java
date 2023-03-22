package com.djx.demo.leetcode.dp;

import java.util.Arrays;

/**
 * day	[1626]无矛盾的最佳球队	51.8%	Medium	0.0%
 *
 * @author dongjingxi
 * @date 2023/3/22
 */
public class BestTeamScore {


    public static void main(String[] args) {

    }


    public int bestTeamScore(int[] scores, int[] ages) {
        int num = scores.length;
        int[][] people = new int[num][2];
        for (int i = 0; i < num; ++i) {
            people[i] = new int[]{scores[i], ages[i]};
        }

        // 根据年龄排序
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);


        int[] dp = new int[num];

        int result = 0;

        for (int i = 0; i < scores.length; i++) {

            // 从前一位开始比较，如果年龄大了（因为是按分数大排，所以后面的分数小）。也就是说，找到年龄严格小于的，作为最大值
            for (int j = i - 1; j >= 0; --j) {
                if (people[i][1] >= people[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            // 加上分数
            dp[i] = dp[i] + people[i][0];
            result = Math.max(result, dp[i]);

        }

        return result;
    }


}
