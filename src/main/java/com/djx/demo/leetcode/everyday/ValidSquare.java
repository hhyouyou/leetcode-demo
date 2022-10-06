package com.djx.demo.leetcode.everyday;

/**
 * day	[593]有效的正方形	44.2%	Medium	0.0%
 *
 * @author dongjingxi
 * @date 2022/7/29
 */
public class ValidSquare {


    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {


        double p1p2length = Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
        double p1p3length = Math.pow(p1[0] - p3[0], 2) + Math.pow(p1[1] - p3[1], 2);
        double p1p4length = Math.pow(p1[0] - p4[0], 2) + Math.pow(p1[1] - p4[1], 2);
        double p2p3length = Math.pow(p2[0] - p3[0], 2) + Math.pow(p2[1] - p3[1], 2);
        double p2p4length = Math.pow(p2[0] - p4[0], 2) + Math.pow(p2[1] - p4[1], 2);
        double p3p4length = Math.pow(p4[0] - p3[0], 2) + Math.pow(p4[1] - p3[1], 2);


        return false;
    }


}
