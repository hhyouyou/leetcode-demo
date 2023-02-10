package com.djx.demo.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * [1233]删除子文件夹
 *
 * @author dongjingxi
 * @date 2023/2/8 上午8:27
 */
public class RemoveSubfolders {

    public static void main(String[] args) {

        RemoveSubfolders removeSubfolders = new RemoveSubfolders();

        String[] folder = {"/ah/al/am", "/ah/al"};

        List<String> result = removeSubfolders.removeSubfolders(folder);

        System.out.println(result);
    }

    public List<String> removeSubfolders(String[] folder) {

        ArrayList<String> result = new ArrayList<>();

        ArrayList<String>[] folderLevel = new ArrayList[100];

        // 按目录层级，初始化数据
        for (String s : folder) {
            String[] split = s.split("/");

            int level = split.length - 2;
            ArrayList<String> list = folderLevel[level];

            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(s);

            folderLevel[level] = list;
        }

        for (ArrayList<String> strings : folderLevel) {
            if (strings == null) {
                continue;
            }
            // 同一层级的，去遍历上层的,是否是子文件夹
            List<String> tmp = new ArrayList<>();
            for (String string : strings) {
                if (!isStartWith(string, result)) {
                    tmp.add(string);
                }
            }
            result.addAll(tmp);
        }

        return result;
    }


    public boolean isStartWith(String str, List<String> set) {
        for (String s : set) {
            if (str.startsWith(s + "/")) {
                return true;
            }
        }
        return false;
    }


}
