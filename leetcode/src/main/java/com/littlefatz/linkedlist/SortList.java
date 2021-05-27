package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

//https://leetcode-cn.com/problems/sort-list/
//https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
public class SortList {

    /**
     * 使用归并排序思想
     * @param head
     * @return
     */
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode fast = head.next;
//        ListNode slow = head;
//
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        ListNode rightStartNode = slow.next;
//        slow.next = null;//注意这里必须把链表从中间断开
//        ListNode leftStartNode = head;
//
//        ListNode left = sortList(leftStartNode);
//        ListNode right = sortList(rightStartNode);
//
//        ListNode temp = new ListNode(-1);
//        ListNode result = temp;
//        while (left != null && right != null) {
//            if (left.val <= right.val) {
//                temp.next = left;
//                left = left.next;
//            } else {
//                temp.next = right;
//                right = right.next;
//            }
//            temp = temp.next;
//        }
//
//        if (left != null) {
//            temp.next = left;
//        }
//        if (right != null) {
//            temp.next = right;
//        }
//
//        return result.next;
//    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next;//这里必须是从head.next开始
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode leftStart = head;
        ListNode rightStart = slow.next;
        slow.next = null;

        ListNode left = sortList(leftStart);
        ListNode right = sortList(rightStart);

        ListNode temp = new ListNode(-1);
        ListNode result = temp;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;

        }

        if (left != null) {
            temp.next = left;
        }

        if (right != null) {
            temp.next = right;
        }

        return result.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node4.next = node2;
        node2.next = node1;
        node1.next = node3;

        SortList test = new SortList();
        test.sortList(node4);
    }






}
