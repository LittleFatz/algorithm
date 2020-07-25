package com.littlefatz.dp;


//https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
public class MaxSumOfRectangle {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int rows = matrix.length;
        if (rows == 0) {
            return Integer.MIN_VALUE;
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return Integer.MIN_VALUE;
        }
        
        int maxResult = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {

            int[] rowSum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][right];
                }
                maxResult = Math.max(maxResult, getMaxResult(rowSum, k));
            }
            

        }

        return maxResult;

    }

    private int getMaxResult(int[] arr, int k) {

        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) rollSum += arr[i];
            else rollSum = arr[i];
            if (rollSum > rollMax) rollMax = rollSum;
        }
        if (rollMax <= k) return rollMax;
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) max = sum;
                if (max == k) return k; // 尽量提前
            }
        }
        return max;

    }

    public static void main(String[] args) {
        MaxSumOfRectangle test = new MaxSumOfRectangle();
//        int[][] data = new int[][]{{1,0,1}, {0,-2,3}};
//        int[][] data = new int[][]{{2,2,-1}};
        int[][] data = new int[][]{{5,-4,-3,4}, {-3,-4,4,5},{5,1,5,-4}};
        System.out.println(test.maxSumSubmatrix(data, 8));
    }
}
