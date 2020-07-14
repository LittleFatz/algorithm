package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

//https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {


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
}
