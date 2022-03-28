package com.example.xylearn.algorithm;

import com.example.xylearn.common.ListNode;

/**
 * @author xiaoy
 * @date 2022/2/15
 */
public class ReverseKListNode {
    public static void main(String[] args) throws Exception {
        ListNode listNode = new ListNode("1");
        ListNode all = listNode.setNextAndGet("2").setNextAndGet("3").setNextAndGet("4").
                setNextAndGet("5").setNextAndGet("6").setNextAndGet("7");
        ListNode tumy = new ListNode(0);
        tumy.next = listNode;


        ListNode pre = tumy;
        ListNode cur = listNode;
        ListNode next = listNode.next;
        for (int i = 0; i < 2; i++) {
            int k = 3;//
            for (int j = 0; j < k - 1; j++) {
                ListNode temp = next.next;
                next.next = cur;

                cur = next;
                next = temp;
            }
            ListNode temp1 = pre.next;
            pre.next = cur;
            temp1.next = next;

            cur = next;
            next = next.next;
            pre = temp1;


        }

        while (tumy.next != null) {
            tumy = tumy.next;
            System.out.print(tumy.getValue() + " ");
        }

    }
}
