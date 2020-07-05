package com.littlefatz.dp;

//https://leetcode-cn.com/problems/maximum-product-subarray/description/
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = nums[0];//min
        dp[0][1] = nums[0];//max

        for (int i = 1; i < length; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
            } else {
                dp[i][0] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][1] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (dp[i][1] > max) {
                max = dp[i][1];
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int[] data = new int[]{2,3,-2,4};
        MaximumProductSubarray test = new MaximumProductSubarray();
        System.out.println(test.maxProduct(data));


    }
}
