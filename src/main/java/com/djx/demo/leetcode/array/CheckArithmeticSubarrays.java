package com.djx.demo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * day	[1630]等差子数组	76.4%	Medium	0.0%
 *
 * @author dongjingxi
 * @date 2023/3/23
 */
public class CheckArithmeticSubarrays {


    public static void main(String[] args) {
        System.out.println(0 % 1);

        CheckArithmeticSubarrays checkArithmeticSubarrays = new CheckArithmeticSubarrays();
        int[] nums = {-3, -6, -8, -4, -2, -8, -6, 0, 0, 0, 0};
        int[] l = {7};
        int[] r = {10};
        List<Boolean> booleans = checkArithmeticSubarrays.checkArithmeticSubarrays2(nums, l, r);
        System.out.println(booleans);
    }


    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> result = new ArrayList<>(l.length);

        for (int i = 0; i < l.length; i++) {
            result.add(true);
        }


        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];

            int[] range = Arrays.copyOfRange(nums, start, end + 1);
//            System.out.println("截取数据: " + Arrays.toString(range));
            Arrays.sort(range);

//            System.out.println("排序后: " + Arrays.toString(range));
            int max = range[range.length - 1];
            int min = range[0];

            double diff = (max - min) / (double) (range.length - 1);

//            System.out.println("max:{"+max+"}, min:{"+min+"}, diff:{"+diff+"}");

            for (int j = 1; j < range.length; j++) {
                if (diff != range[j] - range[j - 1]) {
                    result.set(i, false);
                    break;
                }
            }
        }

        return result;
    }


    public List<Boolean> checkArithmeticSubarrays2(int[] nums, int[] l, int[] r) {

        List<Boolean> result = new ArrayList<>(l.length);

        for (int i = 0; i < l.length; i++) {
            result.add(true);
        }


        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];


            int length = end - start + 1;
            int max = nums[start];
            int min = nums[start];
            for (int k = start; k <= end; k++) {
                max = Math.max(nums[k], max);
                min = Math.min(nums[k], min);
            }

            int[] range = Arrays.copyOfRange(nums, start, end + 1);
            System.out.println("截取数据: " + Arrays.toString(range));


            double diff = (max - min) / (double) (length - 1);

            System.out.println("max:{" + max + "}, min:{" + min + "}, diff:{" + diff + "}");


            // 公差不是整数，直接是错误的
            if (diff % 1 != 0) {
                result.set(i, false);
                continue;
            }


            for (int k = start; k <= end; k++) {

                // 公差为0，直接是相等
                if (diff == 0) {
                    if (nums[k] != min) {
                        result.set(i, false);
                        break;
                    }
                } else {

                    // 遍历， 减去最小值后，是否是公差的整数倍
                    if ((nums[k] - min) % diff != 0) {
                        result.set(i, false);
                        break;
                    }
                }


            }

        }

        return result;
    }


}
