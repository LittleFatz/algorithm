package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//https://leetcode-cn.com/problems/linked-list-cycle-ii
//快慢指针

public class LinkedListCycleII {

    public ListNode detectCycle3(ListNode head) {
        Set<ListNode> index = new HashSet<>();
        ListNode current = head;
        while (current != null && current.next != null) {
            if (index.contains(current)) {
                return current;
            } else {
                index.add(current);
                current = current.next;
            }
        }

        return null;

    }

    public ListNode detectCycle2(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;
        boolean meet = false;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                meet = true;
                break;
            }
        }
        if (meet) {
            runner = head;
            while (runner != walker) {
                runner = runner.next;
                walker = walker.next;
            }

            return walker;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        List<ListNode> list = IntStream.rangeClosed(1,5).mapToObj(i -> {return new ListNode(i);}).collect(Collectors.toList());
        for (int i=0;i<list.size();i++) {
            if (i+1 < list.size()) {
                list.get(i).next = list.get(i+1);
            }
        }
        ListNode head = list.get(0);
        list.get(4).next = list.get(1);

        LinkedListCycleII test = new LinkedListCycleII();
        head = test.detectCycle(head);
        System.out.println(head.val);


    }

    public ListNode detectCycle4(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean meet = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                meet = true;
                break;
            }
        }

        if (meet) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
//            if (slow == fast) {
//                return slow;
//            }
            return slow;
        }
        return null;


    }

    public ListNode detectCycle5(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        boolean meet = false;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meet = true;
                break;
            }
        }

        if (meet) {
            fast = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }

            return fast;
        } else {
            return null;
        }



    }

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean meet = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meet = true;
                break;
            }
        }

        if (!meet) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }




















}
