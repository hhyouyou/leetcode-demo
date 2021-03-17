package com.djx.demo.leetcode.util;

/**
 * @author dong jing xi
 * @date 2020/12/29 0:45
 **/
public class DemoA2B {

    static String table = "fZodR9XQDSUm21yCkr6zBqiveYah8bt4xsWpHnJE7jL5VG3guMTKNPAwcF";
    static Long xor = 177451812L;
    static Long add = 8728348608L;
    static int[] times = {11, 10, 3, 8, 4, 6};

    public static void main(String[] args) {
        String av = bv2av("BV1bz4y1r7Ug");
        System.out.println(av);
        String av2bv = av2bv(Long.parseLong(av.replace("av", "")));
        System.out.println(av2bv);
    }

    public static String bv2av(String bv) {
        long result = 0L;
        for (int i = 0; i < times.length; i++) {
            result += table.indexOf(bv.charAt(times[i])) * Math.pow(58, i);
        }
        return "av" + ((result - add) ^ xor);
    }

    public static String av2bv(long av) {
        av = (av ^ xor) + add;
        char[] result = {'B', 'V', '1', '0', '0', '4', '0', '1', '0', '7', '0', '0'};
        for (int i = 0; i < times.length; i++) {
            result[times[i]] =  table.charAt((int) (av / (Math.pow(58, i)) % 58));
        }
        return String.valueOf(result);
    }

}
