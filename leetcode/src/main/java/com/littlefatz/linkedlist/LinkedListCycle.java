package com.littlefatz.linkedlist;


//https://leetcode-cn.com/problems/linked-list-cycle
//快慢指针

import com.littlefatz.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;

            if (runner == walker) {
                return true;
            }
        }
        return false;

    }
}
