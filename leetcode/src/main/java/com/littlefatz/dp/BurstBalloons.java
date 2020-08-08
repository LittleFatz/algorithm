package com.littlefatz.dp;

//https://leetcode-cn.com/problems/burst-balloons/
public class BurstBalloons {

    public int maxCoins(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int[] points = new int[length + 2];
        points[0] = 1;
        points[length + 1] = 1;
        for (int i = 0; i < length; i++) {
            points[i + 1] = nums[i];
        }

        int[][] dp = new int[length + 2][length + 2];
        for (int i = length + 1; i >= 0; i--) {
            for (int j = i + 1; j <= length + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }

        return dp[0][length + 1];

    }

    public static void main(String[] args) {
        int[] data = new int[]{3,1,5,8};
        BurstBalloons test = new BurstBalloons();
        System.out.println(test.maxCoins(data));
    }
}
