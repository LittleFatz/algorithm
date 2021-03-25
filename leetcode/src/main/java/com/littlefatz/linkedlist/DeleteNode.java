package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

//https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {

        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            if (current.val == val) {
                if (pre != null) {
                    pre.next = current.next;
                    return head;
                } else {
                    return current.next;
                }
            } else {
                pre = current;
                current = current.next;
            }
        }
        return head;
    }
}
