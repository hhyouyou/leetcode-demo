package com.djx.demo.leetcode.everyday;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * ✔[3]无重复字符的最长子串
 *
 * @author djx
 * @date 2021/10/15 上午11:28
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);

        int max = 0;

        byte[] substring = {bytes[0]};

        for (int i = 1; i < bytes.length; i++) {
            // 记录最大长度
            max = getMax(max, substring.length);

            // 对substring 做剪切, 剪掉重复数据之前的东西  abcd + b ==> cd + b
            substring = isExistAndUpdate(substring, bytes[i]);

            substring = byteArrayAdd(substring, bytes[i]);
        }

        max = getMax(max, substring.length);
        return max;
    }

    private static int getMax(int max, int other) {
        if (max < other) {
            max = other;
        }
        return max;
    }

    public static byte[] isExistAndUpdate(byte[] substring, byte newByte) {

        for (int i = 0; i < substring.length; i++) {

            if (substring[i] == newByte) {
                if (i == substring.length - 1) {
                    return new byte[]{};
                }
                return Arrays.copyOfRange(substring, i + 1, substring.length);
            }
        }
        return substring;
    }

    public static byte[] byteArrayAdd(byte[] substring, byte newByte) {

        substring = Arrays.copyOf(substring, substring.length + 1);
        substring[substring.length - 1] = newByte;

        return substring;
    }


}
