package com.djx.demo.leetcode.everyday;

/**
 * [944]删列造序
 *
 * @author dongjingxi
 * @date 2022/5/12
 */
public class MinDeletionSize {


    public static void main(String[] args) {
        MinDeletionSize minDeletionSize = new MinDeletionSize();

        String[] strArray = {"aaa", "dbd", "ccc"};

        System.out.println(minDeletionSize.minDeletionSize(strArray));
    }

    /**
     * 空间是 O(1)
     * 时间是 O(nm) n=strs.length , m=sts[0].length
     */
    public int minDeletionSize(String[] strs) {

        if (strs.length < 1) {
            return 0;
        }

        if (strs[0].length() < 1) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char target = 'a' - 1;
            for (String str : strs) {
                char letter = str.charAt(i);
                if ((letter - target) < 0) {
                    count = count + 1;
                    break;
                }
                target = letter;
            }
        }


        return count;
    }


}
