package com.djx.demo.leetcode.str;

/**
 * day	[824]山羊拉丁文	65.1%	Easy	0.0%
 *
 * @author djx
 * @date 2022/4/21 下午9:11
 */
public class ToGoatLatin {


    public static void main(String[] args) {
        String sentence = "Each word consists of lowercase and uppercase letters only";
        System.out.println(toGoatLatin(sentence));

    }

    public static String toGoatLatin(String sentence) {

        if ("".equals(sentence.trim())) {
            return sentence;
        }

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {

            StringBuilder word = new StringBuilder(words[i]);
            if (!isVowelStart(word.toString())) {
                word = new StringBuilder(word.substring(1) + word.charAt(0));
            }

            word.append("ma");

            for (int j = i; j >= 0; j--) {
                word.append("a");
            }

            words[i] = word.toString();
        }

        return String.join(" ", words);
    }


    public static boolean isVowelStart(String word) {
        String[] vowel = {"a", "e", "i", "o", "u"};

        for (String s : vowel) {
            if (word.toLowerCase().startsWith(s)) {
                return true;
            }
        }
        return false;
    }

}
