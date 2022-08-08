package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * day	[761]特殊的二进制序列	75.2%	Hard	0.0%
 *
 * @author dongjingxi
 * @date 2022/8/8
 */
public class MakeLargestSpecial {


    public String makeLargestSpecial(String s) {


        if (s.length() < 2) {
            return s;
        }


        int count = 0;
        int left = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                count = count + 1;
            } else {
                count = count - 1;
                if (count == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }


        subs.sort(Comparator.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for (String sub : subs) {
            ans.append(sub);
        }

        return ans.toString();
    }


}
