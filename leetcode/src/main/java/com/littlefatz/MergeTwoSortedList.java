package com.littlefatz;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode-cn.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
