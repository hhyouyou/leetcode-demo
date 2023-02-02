package com.djx.demo.leetcode.map;

import java.util.*;

/**
 * day	[1129]颜色交替的最短路径
 *
 * @author dongjingxi
 * @date 2023/2/2
 */
public class ShortestAlternatingPaths {


    public int[] shortestAlternatingPaths1(int n, int[][] redEdges, int[][] blueEdges) {

        // 初始化数据
        List<Integer>[][] next = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                next[i][j] = new ArrayList<>();
            }
        }
        for (int[] edge : redEdges) {
            next[0][edge[0]].add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }


        // 两种类型的颜色最短路径的长度
        int[][] dist = new int[2][n];

        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        dist[0][0] = 0;
        dist[1][0] = 0;
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int x = pair[0], t = pair[1];
            for (int y : next[1 - t][x]) {
                if (dist[1 - t][y] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[1 - t][y] = dist[t][x] + 1;
                queue.offer(new int[]{y, 1 - t});
            }
        }
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }


    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {


        List<Integer>[][] next = new List[2][n];
        for (int c = 0; c < 2; c++) {
            for (int s = 0; s < n; s++) {
                next[c][s] = new ArrayList<>();
            }
        }

        for (int[] edge : redEdges) {
            next[0][edge[0]].add(edge[1]);
        }

        for (int[] edge : blueEdges) {
            next[1][edge[0]].add(edge[1]);
        }


        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        dist[1][0] = 0;

        dfs(new int[]{0, 0}, next, dist);
        dfs(new int[]{1, 0}, next, dist);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            // 从节点0以两种不同颜色的边出发的最短距离的较小值
            answer[i] = Math.min(dist[0][i], dist[1][i]);
            // 最短路径为极大值，说明不可达
            if (answer[i] == Integer.MAX_VALUE) {
                answer[i] = -1;
            }
        }
        return answer;
    }

    private void dfs(int[] pair, List<Integer>[][] next, int[][] dist) {
        // 深度优先搜索
        // pair=[c, x]表示从颜色为c的有向边到达节点x，以x为起点去查找走颜色为1-c的边可以到达的节点
        int c = pair[0], x = pair[1];
        // 遍历以x为起点去走颜色为1-c的边可以到达的节点
        for (int y : next[1 - c][x]) {
            // 如果走颜色为1-c的边可以到达的节点y的最短距离为不可达，或者当前的新距离小于原有的，就需要深度递归
            boolean isDFS = dist[1 - c][y] == Integer.MAX_VALUE || dist[c][x] + 1 < dist[1 - c][y];
            // 更新沿着颜色1-c边到达y的最短距离，当前的最短距离（=从颜色c边到达x的最短距离加上1个距离）和原有的最短距离比较
            dist[1 - c][y] = Math.min(dist[1 - c][y], dist[c][x] + 1);
            if (isDFS) {
                // 以从颜色为1-c的有向边到达y作为pair，进行递归搜索
                dfs(new int[]{1 - c, y}, next, dist);
            }
        }
    }


    public static void main(String[] args) {
        int n = 2;
        String s = "123";
        System.out.println(s.substring(0, s.length() - n));
        System.out.println(s.substring(s.length() - n));
        System.out.println(s.substring(0, 0));
        System.out.println(2 % 5);
    }

    public static String replaceSpace(String s) {
        System.out.println(s.substring(0, s.length()));

        return s.replace(" ", "%20");
    }

}
