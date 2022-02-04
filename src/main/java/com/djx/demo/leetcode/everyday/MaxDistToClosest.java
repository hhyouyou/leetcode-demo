package com.djx.demo.leetcode.everyday;

/**
 * [849]到最近的人的最大距离
 * * @author dong jing xi
 *
 * @date 2022/2/4 17:32
 **/
public class MaxDistToClosest {

    public static void main(String[] args) {

        int[] seats = {0, 1};

        int max = maxDistToClosest(seats);
        System.out.println(max);
    }

    public static int maxDistToClosest(int[] seats) {

        int end = 0;
        int length = 0;
        int result = 0;

        boolean first = true;

        for (int i = 0, j; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (first) {
                    first = false;
                    result = i;
                }
                j = end;
                end = i;
                length = Math.max((end - j), length);
            }
        }

        result = Math.max(result, seats.length - 1 - end);
        result = Math.max(result, length / 2);
        return result;
    }


}
