package com.littlefatz;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {

        int rows = matrix.length;
        if (rows == 0) {
            return new int[0];
        }

        int cols = matrix[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[] result = new int[rows * cols];
        int[] colDirect = new int[]{1, 0, -1, 0};
        int[] rowDirect = new int[]{0, 1, 0, -1};
        int direction = 0;

        int count = 0;
        int row = 0;
        int col = 0;
        while (row >=0 && row < rows && col >= 0 && col < cols &&!visited[row][col]) {
            result[count++] = matrix[row][col];
            visited[row][col] = true;

            int newRow = row + rowDirect[direction];
            int newCol = col + colDirect[direction];
            if (newRow >=0 && newRow < rows && newCol >= 0 && newCol < cols &&!visited[newRow][newCol]) {
                row = newRow;
                col = newCol;
            } else {
                direction = (direction + 1) % 4;
                row = row + rowDirect[direction];
                col = col + colDirect[direction];
            }

        }


        return result;

    }

    public static void main(String[] args) {
        SpiralOrder test = new SpiralOrder();
//        int[][] data = new int[][]{{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
        int[][] data = new int[][]{{ 1}};
        System.out.println(test.spiralOrder(data));
    }
}
