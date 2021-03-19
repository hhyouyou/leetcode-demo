package com.djx.demo.leetcode.struct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author djx
 * @date 2021/3/19 下午5:07
 */
class MyLinkListTest {
    private MyLinkList<String> stringMyLinkList;


    @BeforeEach
    void setUp() {
        stringMyLinkList = new MyLinkList<>();

        stringMyLinkList.add("e1");
        stringMyLinkList.add("e2");
        stringMyLinkList.add("e3");
        stringMyLinkList.add("e4");
        stringMyLinkList.add("e5");
        stringMyLinkList.add("e6");
    }

    @Test
    void add() {

        String s = stringMyLinkList.indexOf(0);
        System.out.println(s);

        s = stringMyLinkList.pollFirst();
        System.out.println(s);

        s = stringMyLinkList.indexOf(0);
        System.out.println(s);

        s = stringMyLinkList.indexOf(3);
        System.out.println(s);

        s = stringMyLinkList.indexOf(6);
        System.out.println(s);

    }

    @Test
    void remove() {

        String remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);

        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);

    }


    @Test
    void remove2() {

        String remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);

        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);
        remove = stringMyLinkList.remove(0);
        System.out.println(remove);

    }
}