package com.littlefatz.unionfind;

//https://leetcode-cn.com/problems/surrounded-regions/
public class SurroundedRegions {

    private int rows;
    private int cols;


    public void solve(char[][] board) {

        rows = board.length;
        if (rows == 0) {
            return;
        }

        cols = board[0].length;
        if (cols == 0) {
            return;
        }

        int dummy = rows * cols;
        UnionFind unionFind = new UnionFind(dummy + 1);

        //不需要遍历上下左右，只需要遍历右和下即可，因为
        int[] xDim = new int[]{0, 1};
        int[] yDim = new int[]{1, 0};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                        unionFind.union(getIndex(i, j), dummy);
                    } else {
                        for (int k = 0; k < 2; k++) {
                            int newI = i + xDim[k];
                            int newJ = j + yDim[k];
                            if (newI < rows && newJ < cols && board[newI][newJ] == 'O') {
                                unionFind.union(getIndex(i, j), getIndex(newI, newJ));
                            }

                        }
                    }
                }

            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && !unionFind.isConnected(getIndex(i,j), dummy)) {
                    board[i][j] = 'X';
                }
            }
        }


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

        public boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return true;
            }
            return false;
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
}
