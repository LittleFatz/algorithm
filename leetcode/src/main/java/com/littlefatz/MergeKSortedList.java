package com.littlefatz;

//https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/
public class MergeKSortedList {

    /**
     * 归并思想
     * 先把链表数组拆分，分治思想，然后再用归并排序的思想，两两合并链表，最后变成一条有序链表
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//
//        return merge(lists, 0, lists.length - 1);
//    }
//
//    private ListNode merge(ListNode[] lists, int left, int right) {
//        if (left == right) {
//            return lists[left];
//        }
//
//        int middle = (left + right) >> 1;
//        ListNode list1 = merge(lists, left, middle);
//        ListNode list2 = merge(lists, middle + 1, right);
//
//        return merger2List(list1, list2);
//    }
//
//    private ListNode merger2List(ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        }
//
//        if (list2 == null) {
//            return list1;
//        }
//
//        if (list1.val <= list2.val) {
//            //精妙之处，一边归并，一边递归
//            list1.next = merger2List(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = merger2List(list1, list2.next);
//            return list2;
//        }
//
//    }

//    public ListNode mergeKLists2(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//
//        return merge(lists, 0, lists.length - 1);
//    }
//
//    private ListNode merge(ListNode[] lists, int start, int end) {
//        if (start == end) {
//            return lists[start];
//        }
//
//        int middle = (start + end) / 2;
//        ListNode list1 = merge(lists, start, middle);
//        ListNode list2 = merge(lists, middle + 1, end);
//
//        return mergeTwoLists(lists, list1, list2);
//
//    }
//
//    private ListNode mergeTwoLists(ListNode[] lists, ListNode list1, ListNode list2) {
//
//        if (list1 == null) {
//            return list2;
//        }
//
//        if (list2 == null) {
//            return list1;
//        }
//
//        if (list1.val <= list2.val) {
//            list1.next = mergeTwoLists(lists, list1.next, list2);
//            return list1;
//        } else {
//            list2.next = mergeTwoLists(lists, list1, list2.next);
//            return list2;
//        }
//
//
//    }

//
//    public ListNode mergeKLists(ListNode[] lists) {
//
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//
//        return mergeKLists(lists, 0, lists.length - 1);
//
//    }
//
//    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
//        if (start == end) {
//            return lists[start];
//        }
//
//        int middle = start + (end - start) / 2;
//        ListNode leftList = mergeKLists(lists, start, middle);
//        ListNode rightList = mergeKLists(lists, middle + 1, end);
//
//        return mergeTwoLists(leftList, rightList);
//
//    }
//
//    private ListNode mergeTwoLists(ListNode leftList, ListNode rightList) {
//        if (leftList == null) {
//            return rightList;
//        }
//
//        if (rightList == null) {
//            return leftList;
//        }
//
//        if (leftList.val <= rightList.val) {
//            ListNode listNode = mergeTwoLists(leftList.next, rightList);
//            leftList.next = listNode;
//            return leftList;
//        } else {
//            ListNode listNode = mergeTwoLists(leftList, rightList.next);
//            rightList.next = listNode;
//            return rightList;
//        }
//
//    }


    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode result = mergeLists(lists, 0, lists.length - 1);
        return result;

    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {

        if (start == end) {
            return lists[start];
        }

        int middle = (start + end) / 2;
        ListNode leftList = mergeLists(lists, start, middle);
        ListNode rightList = mergeLists(lists, middle + 1, end);

        return merge2Lists(leftList, rightList);
    }

    private ListNode merge2Lists(ListNode leftList, ListNode rightList) {

        if (leftList == null) {
            return rightList;
        }

        if (rightList == null) {
            return leftList;
        }

        if (leftList.val <= rightList.val) {
            ListNode listNode = merge2Lists(leftList.next, rightList);
            leftList.next = listNode;
            return leftList;
        } else {
            ListNode listNode = merge2Lists(leftList, rightList.next);
            rightList.next = listNode;
            return rightList;
        }
    }


}
