package com.littlefatz.UnionFind;

//https://leetcode-cn.com/problems/friend-circles/
public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.count();
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

}
