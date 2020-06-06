package com.littlefatz;

//https://leetcode-cn.com/problems/number-of-islands/
public class NumbersOfIsland {

    private int row;
    private int col;

    //FloodFill思想
    public int numIslands(char[][] grid) {
        int count = 0;

        if (grid.length == 0) {
            return count;
        }

        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

            }
        }

        return count;

    }

    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') {
             return;
        }
        grid[i][j] = '0';

        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        NumbersOfIsland solution = new NumbersOfIsland();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution.numIslands(grid2);
        System.out.println(numIslands2);
    }




}
