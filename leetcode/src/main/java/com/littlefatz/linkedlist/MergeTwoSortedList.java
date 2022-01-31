package com.littlefatz.linkedlist;


import com.littlefatz.ListNode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode-cn.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedList {

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;

            } else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }

        }

        if (l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }

        return result.next;

    }

    public static void main(String[] args) {
        List<ListNode> list = IntStream.rangeClosed(1,3).mapToObj(i -> {return new ListNode(i);}).collect(Collectors.toList());
        for (int i=0;i<list.size();i++) {
            if (i+1 < list.size()) {
                list.get(i).next = list.get(i+1);
            }
        }

        List<ListNode> list2 = IntStream.rangeClosed(2,4).mapToObj(i -> {return new ListNode(i);}).collect(Collectors.toList());
        for (int i=0;i<list2.size();i++) {
            if (i+1 < list2.size()) {
                list2.get(i).next = list2.get(i+1);
            }
        }


        MergeTwoSortedList test = new MergeTwoSortedList();
        ListNode head = test.mergeTwoLists(list.get(0), list2.get(0));
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode current = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return head.next;
    }




    public ListNode mergeTwoLists4(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;

        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return head.next;
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode index1 = list1;
        ListNode index2 = list2;
        ListNode head = new ListNode(0);
        ListNode currentNode = head;

        while (index1 != null && index2 != null) {
            if (index1.val <= index2.val) {
                currentNode.next = index1;
                index1 = index1.next;
            } else {
                currentNode.next = index2;
                index2 = index2.next;
            }

            currentNode = currentNode.next;

        }

        if (index1 != null) {
            currentNode.next = index1;
        }

        if (index2 != null) {
            currentNode.next = index2;
        }

        return head.next;
    }



}
