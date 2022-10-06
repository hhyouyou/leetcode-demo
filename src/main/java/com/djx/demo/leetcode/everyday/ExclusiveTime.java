package com.djx.demo.leetcode.everyday;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * [636]函数的独占时间
 * <p>
 * 思路：
 * 题目都说了按栈先进先出
 * 所以第一反应就是按栈来， 只不过， 一开始想在栈中记录一个任务号，一个执行或者开始的时间
 * 然后每次如果是开始，就记录上一个任务执行的时间，
 * 如果是结束就记录当前任务的结束时间，并弹出（因为开始结束都是两两对应的）
 *
 * @author dongjingxi
 * @date 2022/8/7
 */
public class ExclusiveTime {


    /**
     * n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
     */
    public static void main(String[] args) {

        ExclusiveTime exclusiveTime = new ExclusiveTime();
//        String[] log = {"0:start:0", "1:start:2", "1:end:5", "0:end:6"};
        String[] log = {"0:start:0", "0:end:0"};
        List<String> logs = Arrays.asList(log);
        int[] result = exclusiveTime.exclusiveTime(2, logs);

        System.out.println(Arrays.toString(result));
    }

    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];

        LinkedList<Integer> stack = new LinkedList<>();

        int currentTime = 0;

        for (String log : logs) {

            String[] logArray = log.split(":");

            Integer fun = Integer.parseInt(logArray[0]);
            String status = logArray[1];
            int exeTime = Integer.parseInt(logArray[2]);

            if (status.equals("start")) {

                if (!stack.isEmpty()) {
                    Integer lastFun = stack.peek();
                    result[lastFun] = result[lastFun] + (exeTime - currentTime);
                }
                stack.push(fun);
                currentTime = exeTime;

            } else {
                Integer lastFun = stack.pop();
                result[lastFun] = result[lastFun] + (exeTime - currentTime) + 1;
                currentTime = exeTime + 1;
            }
        }

        return result;
    }

}
