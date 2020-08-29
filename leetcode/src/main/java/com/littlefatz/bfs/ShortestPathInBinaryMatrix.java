package com.littlefatz.bfs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[rows][cols];
        int[] rowDirection = new int[]{-1,-1,0,1,1,1,0,-1};
        int[] colDirection = new int[]{0,1,1,1,0,-1,-1,-1};
        int step = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int[] point = queue.poll();
                if (point[0] == rows - 1 && point[1] == cols - 1) {
                    return step;
                }

                grid[point[0]][point[1]] = 1;
                for (int i = 0; i < 8; i++) {
                    int newRow = point[0] + rowDirection[i];
                    int newCol = point[1] + colDirection[i];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }

            step++;
        }

        return -1;
    }


    public static void main(String[] args) {
        ShortestPathInBinaryMatrix test = new ShortestPathInBinaryMatrix();
        int[][] data = new int[][]{{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(test.shortestPathBinaryMatrix(data));
    }
}
