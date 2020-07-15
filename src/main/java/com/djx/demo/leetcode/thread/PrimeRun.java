package com.djx.demo.leetcode.thread;

/**
 * @author dong jing xi
 * @date 2020/4/27 17:24
 **/
public class PrimeRun implements Runnable {
    long minPrime;

    public PrimeRun(long minPrime) {
        this.minPrime = minPrime;
    }

    @Override
    public void run() {
        System.out.println("1111");
    }
}
