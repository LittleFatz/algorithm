package com.littlefatz.binarysearch;

//https://leetcode-cn.com/problems/search-a-2d-matrix/
public class Search2DMatrix {

    //循环遍历
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }
        int rowCount = matrix.length - 1;

        if (matrix[0].length == 0) {
            return false;
        }
        int colCount = matrix[0].length - 1;

        for (int row = 0; row <= rowCount; row++) {

            if (target >= matrix[row][0] && target <= matrix[row][colCount]) {
                for (int col = 0; col <= colCount; col++) {
                    if (matrix[row][col] == target) {
                        return true;
                    }
                }
                return false;
            }
        }

        return false;
    }

    //二分查找
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int rowCount = matrix.length;

        if (matrix[0].length == 0) {
            return false;
        }
        int colCount = matrix[0].length;

        int left = 0;
        int right = rowCount * colCount - 1;
        int midRowIndex = 0;
        int midColIndex = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            midRowIndex = mid / colCount;
            midColIndex = mid % colCount;

            if (matrix[midRowIndex][midColIndex] == target) {
                return true;
            } else if (target < matrix[midRowIndex][midColIndex]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }

        return false;


    }

    public static void main(String[] args) {
        Search2DMatrix test = new Search2DMatrix();
        test.searchMatrix(new int[0][0], 0);
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {
                for (int j = 0; j < cols; j++) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                }
            }

        }

        return false;
    }
}
