package com.djx.demo.leetcode.array;

/**
 * day	[1032]字符流	55.4%	Hard	0.0%
 *
 * @author dongjingxi
 * @date 2023/3/24
 */
public class StreamChecker {


    private final String[] words;
    private String stream = "";


    public StreamChecker(String[] words) {
        this.words = words;
    }

    /**
     * 先试一试暴力解法
     *
     */
    public boolean query(char letter) {

        stream = stream + letter;

        for (String word : words) {
            if (stream.endsWith(word)) {
                return true;
            }
        }


        return false;
    }


}
