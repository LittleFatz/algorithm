package com.littlefatz.linkedlist;


import com.littlefatz.ListNode;

//https://leetcode-cn.com/problems/add-two-numbers/
public class AddTwoNumbers {

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//
//        ListNode dummyHead = new ListNode(0);
//        ListNode current = dummyHead;
//        ListNode head1 = l1;
//        ListNode head2 = l2;
//        int carry = 0;
//
//        while (head1 != null || head2 != null) {
//            int value1 = head1 == null ? 0 : head1.val;
//            int value2 = head2 == null ? 0 : head2.val;
//
//            int total = value1 + value2 + carry;
//            carry = total / 10;
//            total = total % 10;
//
//            current.next = new ListNode(total);
//            current = current.next;
//
//            head1 = head1 == null ? null : head1.next;
//            head2 = head2 == null ? null : head2.next;
//
//        }
//
//        if (carry > 0) {
//            current.next = new ListNode(carry);
//        }
//
//        return dummyHead.next;
//
//    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {


        ListNode result = new ListNode(0);
        ListNode current = result;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {

            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            int value = carry % 10;
            current.next = new ListNode(value);
            carry = carry / 10;
            current = current.next;

        }

        return result.next;

    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null || l2 != null || carry != 0) {
            int value1 = 0;
            int value2 = 0;

            if (l1 != null) {
                value1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value2 = l2.val;
                l2 = l2.next;
            }


            int sum = value1 + value2 + carry;
            int value = sum % 10;
            carry = sum / 10;
            current.next = new ListNode(value);
            current = current.next;

        }

        return head.next;
    }










    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }


        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode current = head;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            int val2 = 0;
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int sum = val1 + val2 + carry;
            int newVal = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(newVal);
            current.next = newNode;
            current = newNode;

        }

        return head.next;
    }

}
