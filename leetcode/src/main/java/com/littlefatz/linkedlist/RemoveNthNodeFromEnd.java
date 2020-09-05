package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode current = result;
        ListNode pre = null;

        int i = 1;
        while (head != null) {
            if (i >= n) {
                pre = current;
                current = current.next;

            }
            head = head.next;
            i++;
        }

        pre.next = pre.next.next;

        return result.next;
    }
}
