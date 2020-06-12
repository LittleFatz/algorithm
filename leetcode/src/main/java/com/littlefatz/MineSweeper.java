package com.littlefatz;

//https://leetcode-cn.com/problems/minesweeper/description/
public class MineSweeper {

    //根据click的不同情况，逐步拆分处理
    public char[][] updateBoard(char[][] board, int[] click) {

        int rows = board.length;
        int cols = board[0].length;

        int row = click[0];
        int col = click[1];

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        int mineCount = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols) {
                    if (board[newRow][newCol] == 'M') {
                        mineCount++;
                    }
                }
            }
        }

        if (mineCount > 0) {
            board[row][col] = (char)('0' + mineCount);
            return board;
        } else {
            board[row][col] = 'B';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int newRow = row + i;
                    int newCol = col + j;
                    if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols
                            && board[newRow][newCol] == 'E') {
                        updateBoard(board, new int[]{newRow, newCol});
                    }
                }
            }

        }
        return board;

    }

    public static void main(String[] args) {
        char[][] board = {{'E','E','E','E','E'}, {'E','E','M','E','E'}, {'E','E','E','E','E'}, {'E','E','E','E','E'}};
        int[] click = new int[]{3,0};
        MineSweeper test = new MineSweeper();
        board = test.updateBoard(board, click);
        System.out.println(board[0]);
    }


    //参考答案
    public char[][] updateBoard2(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board, click[0], click[1]);
        return board;
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'E') {
            return;
        }
        int mine = 0;
        int startRow = i - 1 < 0? 0: i - 1;
        int endRow = i + 1 >= board.length? board.length - 1: i + 1;
        int startCol = j - 1 < 0? 0: j - 1;
        int endCol = j + 1 >= board[0].length? board[0].length - 1: j + 1;
        for (int m = startRow; m <= endRow; m++) {
            for (int n = startCol; n <= endCol; n++) {
                if (board[m][n] == 'M' || board[m][n] == 'X') {
                    mine++;
                }
            }
        }
        if (mine != 0) {
            board[i][j] = (char)(mine + '0');
        } else {
            board[i][j] = 'B';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
            dfs(board, i + 1, j + 1);
            dfs(board, i + 1, j - 1);
            dfs(board, i - 1, j - 1);
            dfs(board, i - 1, j + 1);
        }
    }

}
