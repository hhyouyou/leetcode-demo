package com.djx.demo.leetcode;

import lombok.*;

import java.util.Objects;

public class AddTwoNumbers {

    public static void main(String[] args) {
//        [2,4,3] [5,6,4]

        ListNode l1 = ListNode.builder()
                .val(3)
                .next(ListNode.builder()
                        .val(4)
                        .next(ListNode.builder()
                                .val(2)
                                .build())
                        .build())
                .build();
        ListNode l2 = ListNode.builder()
                .val(4)
                .next(ListNode.builder()
                        .val(6)
                        .next(ListNode.builder()
                                .val(5)
                                .build())
                        .build())
                .build();

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode head = result;
        int cache = 0;
        do {
            ListNode node = new ListNode();
            int resultValue = cache;
            if (Objects.nonNull(l1)) {
                resultValue = resultValue + l1.val;
            }
            if (Objects.nonNull(l2)) {
                resultValue += l2.val;
            }

            node.val = resultValue % 10;
            cache = resultValue / 10;
            node.next = new ListNode();

            head.next = node;
            head = head.next;

            l1 = Objects.isNull(l1) ? null : l1.next;
            l2 = Objects.isNull(l2) ? null : l2.next;
        } while (Objects.isNull(l1) && Objects.isNull(l2));


        return result;
    }

    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListNode {
        int val;
        ListNode next;

    }


}
