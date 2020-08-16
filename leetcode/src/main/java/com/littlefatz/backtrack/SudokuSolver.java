package com.littlefatz.backtrack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode-cn.com/problems/sudoku-solver/
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);

    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';

                        }
                    }

                    /**
                     * 这个 return false是关键
                     * return false的意思是这一层无论填什么都无法符合数独的要求
                     * 证明上一层填错数字，需要返回false实现backtrack
                     */
                    return false;
                }
            }
        }

        return true;
    }


    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }


}
