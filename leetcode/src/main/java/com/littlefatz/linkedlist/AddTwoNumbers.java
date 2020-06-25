package com.littlefatz.linkedlist;


import com.littlefatz.ListNode;

//https://leetcode-cn.com/problems/add-two-numbers/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int carry = 0;

        while (head1 != null || head2 != null) {
            int value1 = head1 == null ? 0 : head1.val;
            int value2 = head2 == null ? 0 : head2.val;

            int total = value1 + value2 + carry;
            carry = total / 10;
            total = total % 10;

            current.next = new ListNode(total);
            current = current.next;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;

        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;

    }
}
