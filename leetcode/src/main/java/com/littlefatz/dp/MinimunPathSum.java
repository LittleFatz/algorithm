package com.littlefatz.dp;

//https://leetcode-cn.com/problems/minimum-path-sum/
public class MinimunPathSum {

    public int minPathSum(int[][] grid) {

        int n = grid.length;
        if (n == 0) {
            return 0;
        }

        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        dp[1][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i+1][j+1] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
            }
        }


        return dp[n][m];


    }

    //参考答案
    //直接利用grid数组保存dp状态
    //通过if else处理边界条件
    public int minPathSum2(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }



    public static void main(String[] args) {
        MinimunPathSum test = new MinimunPathSum();
        int[][] data = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};

        System.out.println(test.minPathSum(data));

    }
}
