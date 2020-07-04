package com.littlefatz.dp;

//https://leetcode-cn.com/problems/unique-paths-ii/
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;


        int[][] dp = new int[n + 1][m + 1];

        dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];

    }


    /*
    This is a typical 2D DP problem, we can store value in 2D DP array,
     but since we only need to use value at dp[i - 1][j] and dp[i][j - 1] to update dp[i][j],
      we don't need to store the whole 2D table, but instead store value in an 1D array,
       and update data by using dp[j] = dp[j] + dp[j - 1],
        (where here dp[j] corresponding to the dp[i - 1][j]) and
         dp[j - 1] corresponding to the dp[i][j - 1] in the 2D array)
     */
    //这里直接用一维数组代替二维数组
    //

    /**
     * 这里用一维数组代替二维数组保存dp的中间值
     * 扫描的时候，按行从上到下，按列从左到右
     * 由于扫描每一行的时候，dp数组已经保存了上一行的值，因此只需要dp[j] = dp[j] + dp[j - 1]
     * 把左边的值和自身的值加起来，便是这个格的路径总数
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    public static void main(String[] args) {

    }
}
