package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

import java.util.LinkedList;
import java.util.Stack;

//https://leetcode-cn.com/problems/add-two-numbers-ii/
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode result = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int total = val1 + val2 + carry;
            carry = total / 10;
            ListNode currentNode = new ListNode(total % 10);
            currentNode.next = result;
            result = currentNode;

        }

        return result;
    }
}
