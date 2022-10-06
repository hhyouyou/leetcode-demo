package com.djx.demo.leetcode.everyday;

/**
 * [1455]检查单词是否为句中其他单词的前缀
 *
 * @author dongjingxi
 * @date 2022/8/21
 */
public class IsPrefixOfWord {

    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] set = sentence.split(" ");

        for (int i = 0; i < set.length; i++) {

            if (set[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }

}
