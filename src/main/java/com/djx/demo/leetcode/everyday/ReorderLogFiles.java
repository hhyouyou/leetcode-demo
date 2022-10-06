package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * [937]重新排列日志文件
 *
 * @author dongjingxi
 * @date 2022/5/3
 */
public class ReorderLogFiles {


    public static void main(String[] args) {

        String[] logs = {"dig1 8 1 5 1", "let4 art zero", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] strings = reorderLogFiles(logs);
        System.out.println(Arrays.toString(strings));
    }


    public static String[] reorderLogFiles(String[] logs) {
        // 1. 遍历, 分成数字/字母
        // 2. 对字母数组进行排序
        // 3. 合并

        ArrayList<String> digLog = new ArrayList<>();
        ArrayList<String> letLog = new ArrayList<>();

        for (String log : logs) {
            String[] logContent = log.split(" ");
            char c = logContent[1].charAt(0);
            if (c >= '0' && c <= '9') {
                digLog.add(log);
            } else {
                letLog.add(log);
            }
        }


        letLog.sort(Comparator.comparing((String log) -> {
            String[] logContent = log.split(" ", 2);
            return logContent[1];
        }).thenComparing(log -> {
            String[] logContent = log.split(" ", 2);
            return logContent[0];
        }));

        letLog.addAll(digLog);
        return letLog.toArray(new String[0]);
    }

}
