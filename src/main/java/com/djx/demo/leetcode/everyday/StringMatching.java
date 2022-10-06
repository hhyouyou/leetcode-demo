package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * [1408]数组中的字符串匹配
 *
 * @author dongjingxi
 * @date 2022/8/6
 */
public class StringMatching {

    public List<String> stringMatching(String[] words) {

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            for (int j = 0; j < words.length; j++) {

                if (i == j) {
                    continue;
                }

                if (words[j].contains(word)) {
                    result.add(word);
                    break;
                }
            }
        }
        return result;
    }

}
