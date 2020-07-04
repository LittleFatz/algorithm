package com.littlefatz.dp;


import java.util.Arrays;

//https://leetcode-cn.com/problems/unique-paths/
public class UniquePaths {

    //每一格的路径总数 = 右边一格的路径总数 + 下面一格的路径总数
    //因此dp表格为每一格的路径总数
    public int uniquePaths(int m, int n) {
        int[][] board = new int[n + 1][m + 1];

        for (int i = 0; i < m; i++) {
            board[n - 1][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            board[i][m - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                board[i][j] = board[i + 1][j] + board[i][j + 1];
            }
        }

        return board[0][0];

    }

    /** 优秀题解
     * 我们求一个点需要的是它头上的那个点和它本行左边的那个点，只要有这两个点，那么就能够计算出当前点
     * 所以可以直接将两行数据优化为一行，每次循环都会提前计算它左边的点，这个左边的点就可以理解成本行左边的那个点，而因为
     * 当前点还未进行计算，这个位置上实际存储的数据是它头上的那个点（上一行）的数据，因此空间复杂度优化为O(n)
     *
     * @param m -
     * @param n -
     * @return -
     */
    public int uniquePaths2(int m, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] += arr[j - 1];
            }
        }
        return arr[n - 1];
    }


    public static void main(String[] args) {
        UniquePaths test = new UniquePaths();
        System.out.println(test.uniquePaths(3,2));
    }
}
