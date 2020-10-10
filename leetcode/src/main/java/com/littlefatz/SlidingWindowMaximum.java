package com.littlefatz;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode-cn.com/problems/sliding-window-maximum/
//单调双向队列

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow2(int[] nums, int k) {
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

    public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length;
        int[] result = new int[length - k + 1];
        //单调双向队列，队里中储存的是数组index，对列头元素为最大数字的index
        Deque<Integer> deque = new ArrayDeque<>();
        int resultIndex = 0;

        for (int i = 0; i < length; i++) {
            //检查对列头元素index是否已经超出window范围，如果是则移除
            if (!deque.isEmpty() && deque.peek() < (i - k + 1)) {
                deque.removeFirst();
            }
            //从队列尾部开始比较，如果元素小于当前元素，则移除，直到队列为空或者当前元素小于队列元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            //(i-k+1) >= 0 判断什么时候能够获取第一个滑动窗口最大值
            if ((i-k+1) >= 0) {
                result[resultIndex++] = nums[deque.peek()];
            }
        }

        return result;
    }
}
