package com.littlefatz;

//https://leetcode-cn.com/problems/delete-middle-node-lcci/
//https://leetcode-cn.com/problems/delete-middle-node-lcci/solution/nao-jin-ji-zhuan-wan-by-acvv_itdef-d19d/
public class DeleteMiddleNode {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;


    }
}
