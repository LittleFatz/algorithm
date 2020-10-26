package com.littlefatz;

//https://leetcode-cn.com/problems/rotate-matrix-lcci/
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int length = matrix.length;

        //先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再对每一行以中点进行翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = temp;
            }
        }

    }
}
