package com.djx.demo.leetcode.everyday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * day	[676]实现一个魔法字典
 *
 *
 * 这个思路就比较简单， 存一个字段set保证每个都不一样
 *
 * search，就一个个字符去比较， 找到只有一个字符不一样的
 *
 * @author dongjingxi
 * @date 2022/7/11
 */
public class MagicDictionary {


    private final Set<String> magicDictionary;


    public MagicDictionary() {
        magicDictionary = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {

        magicDictionary.addAll(Arrays.asList(dictionary));

    }

    public boolean search(String searchWord) {

        for (String word : magicDictionary) {

            if (word.length() != searchWord.length()) {
                continue;
            }

            int flag = 0;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    flag = flag + 1;
                }
            }

            if (flag == 1) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();

        String[] array = {"hello", "leetcode"};

        magicDictionary.buildDict(array);
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));


    }

}
