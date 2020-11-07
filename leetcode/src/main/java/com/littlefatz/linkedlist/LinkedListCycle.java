package com.littlefatz.linkedlist;


//https://leetcode-cn.com/problems/linked-list-cycle
//快慢指针

import com.littlefatz.ListNode;

public class LinkedListCycle {
    public boolean hasCycle2(ListNode head) {
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


    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;


    }



}
