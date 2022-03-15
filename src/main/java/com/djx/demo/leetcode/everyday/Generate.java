package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * [118]杨辉三角
 *
 * @author dongjingxi
 * @date 2022/3/14
 */
public class Generate {
    public static void main(String[] args) {

        System.out.println(generate(300));

    }


    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> nums = new ArrayList<>(i);
            for (int j = 0; j <= i; j++) {
                Integer left = getNum(result, i - 1, j - 1);
                Integer right = getNum(result, i - 1, j);

                if (left == 0 && right == 0) {
                    nums.add(1);
                }else {
                    nums.add(left + right);
                }
            }
            result.add(nums);
        }
        return result;
    }

    public static Integer getNum(List<List<Integer>> result, int left, int right) {
        if (left >= 0 && left < result.size()) {
            List<Integer> rows = result.get(left);
            if (right >= 0 && right < rows.size()) {
                return rows.get(right);
            }
        }
        return 0;
    }


}
