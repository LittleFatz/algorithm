package com.littlefatz.dfs;

//https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
public class MovingCount {

    private boolean[][] visited;
    private int rows;
    private int cols;

    public int movingCount(int m, int n, int k) {

        rows = m;
        cols = n;
        visited = new boolean[m][n];
        return dfs(0,0, k);
    }

    private int dfs(int i, int j, int k) {
        if (i < rows && j < cols && !visited[i][j] && (getSum(i) + getSum(j) <= k)) {
            visited[i][j] = true;
            return dfs(i + 1, j, k) + dfs(i, j + 1, k) + 1;
        } else {
            return 0;
        }
    }

    private int getSum(int x){
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x = x / 10;
        }

        return sum;
    }
}
