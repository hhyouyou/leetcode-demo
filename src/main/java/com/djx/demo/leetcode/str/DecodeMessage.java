package com.djx.demo.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * [2325]解密消息
 *
 * @author dongjingxi
 * @date 2023/2/1 下午2:33
 */
public class DecodeMessage {

    public static void main(String[] args) {
        System.out.println((int) 'a');

        DecodeMessage decodeMessage = new DecodeMessage();
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(decodeMessage.decodeMessage(key, message));
    }


    public String decodeMessage(String key, String message) {

        // 记录key中的字母，　防止重复
        Map<Character, Character> keyMap = new HashMap<>(32);
        int j = 0;
        for (int i = 0; i < 26; i++) {
            while (j < key.toCharArray().length) {
                char keyChar = key.toCharArray()[j++];
                // 空值，重复值略
                if (keyChar == ' ' || keyMap.containsKey(keyChar)) {
                    continue;
                }
                // 合法值按顺序写入码表
                keyMap.put(keyChar, (char) (i + 97));
                break;
            }
        }


        char[] messageChars = message.toCharArray();
        for (int i = 0; i < messageChars.length; i++) {
            char c = messageChars[i];
            if (keyMap.containsKey(c)) {
                messageChars[i] = keyMap.get(c);
            }
        }


        return String.valueOf(messageChars);
    }

}
