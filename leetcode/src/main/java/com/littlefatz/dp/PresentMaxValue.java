package com.littlefatz.dp;

//https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
public class PresentMaxValue {

    public int maxValue(int[][] grid) {

        int n = grid.length;
        if (n == 0) {
            return 0;
        }

        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i+1][j+1] = Math.max(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        PresentMaxValue test = new PresentMaxValue();
        System.out.println(test.maxValue(data));
    }
}
