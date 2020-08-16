package com.littlefatz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode-cn.com/problems/valid-sudoku/description/
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        int rows = board.length;
        int cols = board.length;

        Map<Integer, Set<Integer>> horizonLine= new HashMap<>();
        Map<Integer, Set<Integer>> verticleLine= new HashMap<>();
        Map<Integer, Set<Integer>> block = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            horizonLine.put(i, new HashSet<>());
            verticleLine.put(i, new HashSet<>());
            block.put(i, new HashSet<>());
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != '.') {
                    int boardValue = board[i][j] - '0';

                    if (horizonLine.get(i).contains(boardValue)) {
                        return false;
                    } else {
                        horizonLine.get(i).add(boardValue);
                    }

                    if (verticleLine.get(j).contains(boardValue)) {
                        return false;
                    } else {
                        verticleLine.get(j).add(boardValue);
                    }

                    int blockIndex = (i / 3) * 3 + j / 3;
                    if (block.get(blockIndex).contains(boardValue)) {
                        return false;
                    } else {
                        block.get(blockIndex).add(boardValue);
                    }
                }

            }
        }

        return true;

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku test = new ValidSudoku();
        System.out.println(test.isValidSudoku(board));


    }
}
