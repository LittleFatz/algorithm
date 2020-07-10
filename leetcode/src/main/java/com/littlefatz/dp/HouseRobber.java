package com.littlefatz.dp;

//https://leetcode-cn.com/problems/house-robber/
public class HouseRobber {

    public int rob(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i< length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[length - 1];
    }

    public static void main(String[] args) {
        HouseRobber test = new HouseRobber();
        int[] data = new int[]{2,7,9,3,1};
        System.out.println(test.rob(data));
    }
}
