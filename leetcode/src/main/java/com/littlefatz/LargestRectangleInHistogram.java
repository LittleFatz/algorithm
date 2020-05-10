package com.littlefatz;


import java.util.Stack;

//https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
//维系单调栈，从底到顶递增

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int area = heights[stack.pop()] * (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);

        }

        while (stack.peek() != -1) {
            int area = heights[stack.pop()] * (heights.length - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }



    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        int area = test.largestRectangleArea(heights);
        System.out.println(area);
    }
}
