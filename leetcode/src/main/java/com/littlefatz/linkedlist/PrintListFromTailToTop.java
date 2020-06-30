package com.littlefatz.linkedlist;

import com.littlefatz.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
public class PrintListFromTailToTop {

    public int[] reversePrint(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode node = head;

        while (node != null) {
            deque.addLast(node.val);
            node = node.next;
        }

        int size = deque.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = deque.pollLast();
        }

        return result;
    }


    //参考答案
    //使用栈
    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;

        PrintListFromTailToTop test = new PrintListFromTailToTop();
        int[] result = test.reversePrint(node1);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
