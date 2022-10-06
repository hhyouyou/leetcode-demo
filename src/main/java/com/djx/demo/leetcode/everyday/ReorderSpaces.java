package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;

/**
 * [1592]重新排列单词间的空格
 *
 * @author dongjingxi
 * @date 2022/2/13
 */
public class ReorderSpaces {


    public static void main(String[] args) {

        String s = reorderSpaces("  this   is  a sentence ");

        System.out.print(s);
    }


    public static String reorderSpaces(String text) {

        ArrayList<String> words = new ArrayList<>();

        int spaceCount = 0;

        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ' ') {
                spaceCount++;
            } else {
                String word = "";
                for (int j = i; j < chars.length; j++, i++) {
                    if (chars[j] != ' ') {
                        word = word + chars[j];
                    } else {
                        spaceCount++;
                        break;
                    }
                }
                words.add(word);
            }
        }

        if (spaceCount == 0) {
            return text;
        }

        if (words.size() == 1) {
            StringBuilder endSpace = new StringBuilder();

            for (int i = 0; i < spaceCount; i++) {
                endSpace.append(' ');
            }

            return words.get(0) + endSpace;
        }

        StringBuilder joinSpace = new StringBuilder();
        for (int i = 0; i < spaceCount / (words.size() - 1); i++) {
            joinSpace.append(' ');
        }
        text = String.join(joinSpace, words);

        StringBuilder endSpace = new StringBuilder();
        for (int i = 0; i < spaceCount % (words.size() - 1); i++) {
            endSpace.append(' ');
        }

        text = text + endSpace;

        return text;
    }

}
