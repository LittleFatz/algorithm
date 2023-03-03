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


    public int trap4(int[] height) {
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


    //https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
    /**
     * 我们先明确几个变量的意思：
     *
     * left_max：左边的最大值，它是从左往右遍历找到的
     * right_max：右边的最大值，它是从右往左遍历找到的
     * left：从左往右处理的当前下标
     * right：从右往左处理的当前下标
     * 定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
     *
     * 定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。（见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）
     *
     * 定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
     *
     *                                    right_max
     *  left_max                             __
     *    __                                |  |
     *   |  |__   __??????????????????????  |  |
     * __|     |__|                       __|  |__
     *         left                      right
     * 对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。无论右边将来会不会出现更大的right_max，都不影响这个结果。 所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
     */
    public int trap5(int[] height) {


        int length = height.length;
        if (length == 0) {
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int rain = 0;

        while (leftIndex < rightIndex) {
            if (height[leftIndex] <= height[rightIndex]) {
                leftMax = Math.max(leftMax, height[leftIndex]);
                rain += leftMax - height[leftIndex];
                leftIndex++;
            } else {
                rightMax = Math.max(rightMax, height[rightIndex]);
                rain += rightMax - height[rightIndex];
                rightIndex--;
            }

        }

        return rain;

    }

    public int trap6(int[] height) {

        int length = height.length;
        if (length <= 1) {
            return 0;
        }

        int left = 0;
        int right = length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int maxRain = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                maxRain += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                maxRain += rightMax - height[right];
                right--;
            }
        }

        return maxRain;
    }


    public int trap(int[] height) {

        int length = height.length;
        if (length <= 1) {
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = length - 1;
        int leftMax = height[0];
        int rightMax = height[length - 1];
        int totalRain = 0;

        while (leftIndex < rightIndex) {
            if (height[leftIndex] <= height[rightIndex]) {
                leftMax = Math.max(height[leftIndex], leftMax);
                totalRain += leftMax - height[leftIndex];
                leftIndex++;
            } else {
                rightMax = Math.max(height[rightIndex], rightMax);
                totalRain += rightMax - height[rightIndex];
                rightIndex--;
            }
        }

        return totalRain;
    }




















}
