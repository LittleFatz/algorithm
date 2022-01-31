package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

import java.util.List;

//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd2(ListNode head, int n) {

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

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        //按照题目意思，n 始终有效。因此如果需要删除的数字在 head 位置，那么 fast 会一直遍历到尾结点的 null
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        // 如果此时快指针走到头了，
        // 说明倒数第 n 个节点就是第一个节点
        if (fast == null) {
            return head.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd4(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        int step = n;

        while (step > 0) {
            fast = fast.next;
            step--;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;

    }

    public ListNode removeNthFromEnd5(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        int step = n;
        while (step > 0) {
            fast = fast.next;
            step--;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        int step = n;
        ListNode slow = head;
        ListNode fast = head;

        while (step > 0) {
            fast = fast.next;
            step--;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;

    }


























}
