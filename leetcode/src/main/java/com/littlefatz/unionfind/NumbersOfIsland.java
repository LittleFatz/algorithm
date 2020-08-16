package com.littlefatz.unionfind;

//https://leetcode-cn.com/problems/number-of-islands/
public class NumbersOfIsland {

    private int rows;
    private int cols;

    //使用并查集解决
    public int numIslands(char[][] grid) {

        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }


        int[] x = new int[]{1, 0};
        int[] y = new int[]{0, 1};

        //所有水域全部连通到一个虚拟节点，所以初始化多一个元素
        int dummy = rows * cols;
        UnionFind unionFind = new UnionFind( dummy + 1);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    unionFind.union(getIndex(i, j), dummy);
                } else {
                    for (int k = 0; k < 2; k++) {
                        int newX = i + x[k];
                        int newY = j + y[k];
                        if (newX < rows && newY < cols && grid[newX][newY] == '1') {
                            unionFind.union(getIndex(i, j), getIndex(newX, newY));
                        }
                    }

                }
            }
        }

        return unionFind.count - 1;

    }

    private int getIndex(int x, int y) {
        return x * cols + y;
    }

    class UnionFind {
        private int count = 0;
        private int[] parent;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootQ] = rootP;
            count--;
        }

        public int count() {
            return count;
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

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
