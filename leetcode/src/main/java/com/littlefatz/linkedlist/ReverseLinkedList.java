package com.littlefatz.linkedlist;


import com.littlefatz.ListNode;

/**
 * Definition for singly-linked linkedlist.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//https://leetcode-cn.com/problems/reverse-linked-list/
public class ReverseLinkedList {
//    public ListNode reverseList(ListNode head) {
//        ListNode previous = null;
//        ListNode current = head;
//        while (current != null) {
//            ListNode next = current.next;
//            current.next = previous;
//            previous = current;
//            current = next;
//
//        }
//
//        return previous;
//
//    }
//
//
//    public ListNode reverseList2(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode current = reverseList2(head.next);
//        head.next.next = head;
//        head.next = null;
//        return current;
//
//    }

    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        return pre;
    }


    public ListNode reverseList3(ListNode head) {

        ListNode pre = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        return pre;
    }


    public ListNode reverseList4(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }

    public ListNode reverseList5(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }


    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;

            pre = current;
            current = next;
        }

        return pre;
    }













}


