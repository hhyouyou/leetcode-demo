package com.djx.demo.leetcode;

import java.util.stream.IntStream;

/**
 * java 1行打印99乘法表
 *
 * @author dongjingxi
 * @date 2023/2/15 下午4:41
 */
public class Test {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 9).forEach(x -> IntStream.rangeClosed(1, x).forEach(y -> System.out.print(x + "*" + y + "=" + x * y + (x == y ? "\n" : "\t"))));
    }
}
