package com.littlefatz;


//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
//https://labuladong.gitee.io/algo/2/17/18/
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup2(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previous = dummy;
        ListNode start = head;
        ListNode end = head;

        while (start != null) {
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode next = end.next;
            end.next = null;
            ListNode subHead = reverse(start);
            previous.next = subHead;
            start.next = next;
            previous = start;
            start = next;
            end = start;

        }

        return dummy.next;

    }

    private ListNode reverse(ListNode start) {
        ListNode previous = null;
        ListNode current = start;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
//
//    public ListNode reverseKGroup3(ListNode head, int k) {
//
//        if (head == null) {
//            return null;
//        }
//
//        ListNode start = head;
//        ListNode end = head;
//        for (int i = 0; i < k; i++) {
//            if (end == null) {
//                return head;
//            }
//            end = end.next;
//        }
//        ListNode newHead = reverse(start, end);
//        ListNode nextHead = reverseKGroup3(end, k);
//        start.next = nextHead;
//        return newHead;
//    }

//    private ListNode reverse(ListNode start, ListNode end) {
//
//        ListNode pre = null;
//        ListNode current = start;
//        ListNode next;
//        while(current != end) {
//            next = current.next;
//            current.next = pre;
//            pre = current;
//            current = next;
//        }
//
//        return pre;
//
//    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }

        ListNode newHead = reverse(start, end);
        ListNode nextHead = reverseKGroup(end, k);
        start.next = nextHead;//start指向的是reverse(start, end)中链表的队尾元素
        return newHead;

    }

    //这个方法只会反转end之前的所有元素,不包括end
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode current = start;
        ListNode next = null;
        while (current != end) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }













}
