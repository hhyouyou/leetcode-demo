package com.djx.demo.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * day	[1797]设计一个验证系统	64.3%	Medium	0.0%
 *
 * @author dongjingxi
 * @date 2023/2/9
 */
public class AuthenticationManager {

    private final Integer timeToLive;


    private final Map<String, Integer> tokenMap;


    public AuthenticationManager(int timeToLive) {

        this.timeToLive = timeToLive;
        tokenMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {

        tokenMap.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {

        Integer time = tokenMap.get(tokenId);
        if (time != null && time > currentTime) {
            tokenMap.put(tokenId, currentTime + timeToLive);
        }

    }

    public int countUnexpiredTokens(int currentTime) {
        int result = 0;

        for (Map.Entry<String, Integer> entry : tokenMap.entrySet()) {

            if (entry.getValue() > currentTime) {
                result = result + 1;
            }
        }

        return result;
    }
}
