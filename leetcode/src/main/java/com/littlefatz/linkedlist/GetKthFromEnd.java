package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

import java.util.List;

//https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
public class GetKthFromEnd {

    public ListNode getKthFromEnd2(ListNode head, int k) {


        ListNode slow = head;
        ListNode fast = head;

        while (k - 1 > 0 && fast != null) {
            fast = fast.next;
            k--;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;


    }

    public ListNode getKthFromEnd3(ListNode head, int k) {

        ListNode slow = head;
        ListNode fast = head;

        int count = k;
        while (count > 0 && fast != null) {
            count--;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        int count = k;
        while (count > 0 && fast != null) {
            count--;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }







}
