package com.littlefatz;


import java.util.Stack;

//https://leetcode-cn.com/problems/trapping-rain-water/
public class TrappingRainWater {

    //单调栈，从底到顶递减
    public int trap3(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int rain = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.empty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int heightGap = Math.min(height[i], height[stack.peek()]) - height[top];
                rain += width * heightGap;
            }

            stack.push(i);

        }

        return rain;
    }

    //双指针
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int rain = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    rain += leftMax - height[left];
                }
                left++;

            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    rain += rightMax - height[right];
                }
                right--;
            }

        }

        return rain;

    }

    public static void main(String[] args) {
        int[] data = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater test = new TrappingRainWater();
        int rain = test.trap2(data);
        System.out.println(rain);
    }


    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int result = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            /**
             * 如果 leftMax <= rightMax，则去计算左边能够接到的雨水
             * 因为 leftMax 已经比当前的 rightMax 小，即使右边出现更高的 rightMax 也不会影响
             * 因为 leftMax 已经比当前的 rightMax 大，那么就去计算右边接到的雨水，如果使用当前 rightMax 计算左边雨水的话，无法保证右边不会出现更小的 rightMax
             */
            if (leftMax <= rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }


        }

        return result;
    }
}
