package com.djx.demo.leetcode.thread;

/**
 * @author dong jing xi
 * @date 2020/4/27 17:19
 **/
public class PrimeThread extends Thread {

    long minPrime;

    public PrimeThread(long minPrime) {
        this.minPrime = minPrime;
    }

    @Override
    public void run() {
        System.out.println("1111");
    }
}
