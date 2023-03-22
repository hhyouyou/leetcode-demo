package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author djx
 * @date 2022/8/12 下午1:55
 */
public class GroupThePeople {


    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        HashMap<Integer, List<Integer>> groupMap = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int group = groupSizes[i];
            List<Integer> userList = groupMap.getOrDefault(group, new ArrayList<>());
            userList.add(i);
            groupMap.put(group, userList);
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> groupList = groupMap.keySet().stream().sorted().collect(Collectors.toList());

        Arrays.sort(groupSizes);

        for (int i = 0; i < groupSizes.length; i++) {


        }


        return null;
    }


    public List<List<Integer>> groupThePeople1(int[] groupSizes) {

        Arrays.sort(groupSizes);

        List<List<Integer>> result = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < groupSizes.length; i++) {
            int group = groupSizes[i];

            List<Integer> groupList = result.get(index);

            if (groupList.size() < group) {
                groupList.add(i);
            } else {
                index = index + 1;

            }

        }


        return null;
    }

}
