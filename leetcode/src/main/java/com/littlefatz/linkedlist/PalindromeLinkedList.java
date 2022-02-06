package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

//https://leetcode-cn.com/problems/palindrome-linked-list/
//https://labuladong.gitee.io/algo/2/17/19/
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            ListNode temp = slow.next;
            fast = fast.next.next;

            //快慢指针一边前进，一边翻转前半段链表
            slow.next = pre;
            pre = slow;
            slow = temp;

        }

        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }

            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }
}
