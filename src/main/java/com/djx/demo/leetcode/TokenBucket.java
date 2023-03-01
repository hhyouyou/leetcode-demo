package com.djx.demo.leetcode;

import cn.hutool.core.collection.ConcurrentHashSet;
import cn.hutool.core.util.RandomUtil;

/**
 * @author djx
 * @date 2021/8/23 下午2:01
 */
public class TokenBucket {


    private static final Integer MAX_COUNT = 1000;

    private static final ConcurrentHashSet<String> TOKEN_BUCKET = new ConcurrentHashSet<>(MAX_COUNT);

    public static void main(String[] args) {


//        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
//        threadPoolTaskScheduler.setThreadNamePrefix("injection--");
//        threadPoolTaskScheduler.setPoolSize(100);
//        threadPoolTaskScheduler.setRejectedExecutionHandler((r, executor) -> System.out.println("。。。"));
//        threadPoolTaskScheduler.initialize();
//
//        threadPoolTaskScheduler.scheduleWithFixedDelay(new Injection(), Duration.ofMillis(500));

//        threadPoolTaskScheduler.


    }

    public static Boolean go() {


        return true;
    }


    public static class service implements Runnable {

        @Override
        public void run() {

            if (!TOKEN_BUCKET.isEmpty()) {


            }

        }
    }


    public static class Injection implements Runnable {

        @Override
        public void run() {

            if (TOKEN_BUCKET.size() < MAX_COUNT) {
                TOKEN_BUCKET.add(getRandomToken());
                System.out.println(TOKEN_BUCKET.size());
            }

        }
    }


    public static String getRandomToken() {
        return RandomUtil.randomString(64);
    }

}
