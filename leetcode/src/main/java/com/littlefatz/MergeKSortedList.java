package com.littlefatz;

//https://leetcode-cn.com/problems/merge-k-sorted-lists/submissions/
public class MergeKSortedList {

    /**
     * 归并思想
     * 先把链表数组拆分，分治思想，然后再用归并排序的思想，两两合并链表，最后变成一条有序链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int middle = (left + right) >> 1;
        ListNode list1 = merge(lists, left, middle);
        ListNode list2 = merge(lists, middle + 1, right);

        return merger2Litst(list1, list2);
    }

    private ListNode merger2Litst(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            //精妙之处，一边归并，一边递归
            list1.next = merger2Litst(list1.next, list2);
            return list1;
        } else {
            list2.next = merger2Litst(list1, list2.next);
            return list2;
        }

    }


}