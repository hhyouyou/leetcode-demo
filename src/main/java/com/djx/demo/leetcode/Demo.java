package com.djx.demo.leetcode;

import java.math.BigDecimal;

/**
 * @author dong jing xi
 * @date 2020/10/6 19:44
 **/
public class Demo {

    public static void main(String[] args) {

        BigDecimal t = BigDecimal.valueOf(27.982);
        BigDecimal k = BigDecimal.valueOf(100);

        BigDecimal y0 = BigDecimal.valueOf(28);
        BigDecimal y1 = y0.subtract(t.divide(k));
        System.out.println(y1);

        BigDecimal y100 = y0;

        for (int i = 0; i < 100; i++) {
            y100 = y100.subtract(t.divide(k));
        }

        System.out.println(y100);


    }


//    public void test1(BigDecimal y) {
//
//        y = test1();
//
//    }


}
