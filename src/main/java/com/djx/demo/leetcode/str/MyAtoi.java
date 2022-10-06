package com.djx.demo.leetcode.str;

/**
 * 字符串转换整数 (atoi)
 * 请你来实现一个atoi函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−2^31, 2^31− 1]。如果数值超过这个范围，请返回 INT_MAX (2^31− 1) 或INT_MIN (−2^31) 。
 *
 * @author dong jing xi
 * @date 2020/12/15 10:39
 */
public class MyAtoi {

    public static void main(String[] args) {

        int num = myAtoi("-+12");
        System.out.println(num);


    }

    public static int myAtoi(String s) {
        long result = 0;
        int negativeFlag = 1;

        s = s.trim();

        char[] chars = s.toCharArray();


        int i = 0;
        for (; i < chars.length; i++) {
            char aChar = chars[i];
            if (!isFlagOrNumber(aChar)) {
                break;
            }
        }

        if (i > 0 && i < chars.length) {
            char aChar1 = chars[i - 1];
            if (aChar1 == '-') {
                negativeFlag = -1;
            }
        }


        for (; i < chars.length; i++) {
            char aChar = chars[i];
            if (!isNumber(aChar)) {
                break;
            }
            result = result * 10 + (aChar - 48);
        }

        result = result * negativeFlag;
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }


        return Math.toIntExact(result);
    }

    public static boolean isNumber(char ch) {
        return ch >= 48 && ch <= 57;
    }


    public static boolean isFlagOrNumber(char ch) {
        return (ch >= 48 && ch <= 57) || (ch == '-' || ch == '+');
    }


    public static int isCrossBorder(int oldNumber, int newNumber) {
        return (oldNumber ^ newNumber) >> 31;
    }
}
