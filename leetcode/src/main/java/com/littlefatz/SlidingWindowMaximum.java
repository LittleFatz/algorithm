package com.littlefatz;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode-cn.com/problems/sliding-window-maximum/
//单调双向队列

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() < (i - k + 1)) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if ((i - k + 1) >= 0) {
                result[resultIndex++] = nums[deque.peek()];
            }


        }

        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,3,1,2,0,5};
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        int[] result = test.maxSlidingWindow(data, 3);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
