package com.djx.demo.leetcode.everyday;

/**
 * [1374]生成每种字符都是奇数个的字符串
 *
 * 这个有点简单， 本质上就是把一个数字拆成奇数
 *
 * 如果是偶数， 那么都可以拆成  1， n-1  两个奇数
 * 如果是奇数， 那么就是偶数加1， 所以就可以拆成 1，1， n-2
 * 倒是一开始忘了0了
 *
 *
 *
 * @author dongjingxi
 * @date 2022/8/1
 */
public class GenerateTheString {

    public static void main(String[] args) {

        GenerateTheString generateTheString = new GenerateTheString();

        System.out.println(generateTheString.generateTheString(10));

    }


    public String generateTheString(int n) {
        StringBuilder result = new StringBuilder();

        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "a";
        }

        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                result.append("a");
            }
            result.append("b");
        } else {

            for (int i = 0; i < n - 2; i++) {
                result.append("a");
            }
            result.append("b").append("c");
        }

        return result.toString();
    }


}
