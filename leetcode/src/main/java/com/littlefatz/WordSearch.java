package com.littlefatz;

//https://leetcode-cn.com/problems/word-search/
public class WordSearch {

    private char[][] localBoard;
    private boolean[][] visited;
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int rows;
    private int cols;
    private int wordLength;
    private char[] chars;


    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }

        cols = board[0].length;
        if (cols == 0) {
            return false;
        }

        localBoard = board;
        visited = new boolean[rows][cols];
        wordLength = word.length();
        chars = word.toCharArray();
        int rowIndex = 0;
        int colIndex = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /**
                 * 这里不能直接 return dfs(i, j, 0)
                 * 如果 dfs = false， 则需要继续遍历其他位置，不能直接 return
                 */
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, int wordIndex) {

        if (wordIndex == wordLength - 1) {
            return chars[wordIndex] == localBoard[x][y];
        }

        if (localBoard[x][y] == chars[wordIndex]) {
            visited[x][y] = true;
            for (int k = 0; k < directions.length; k++) {
                int newx = x + directions[k][0];
                int newy = y + directions[k][1];

                if (inArea(newx, newy) && !visited[newx][newy]) {
                    if (dfs(newx, newy, wordIndex + 1)) {
                        return true;
                    }
                }
            }
            visited[x][y] = false;

        }

        return false;

    }

    private boolean inArea(int x, int y) {
        if (x >= 0 && x < rows && y >=0 && y < cols) {
            return true;
        }

        return false;
    }



}
