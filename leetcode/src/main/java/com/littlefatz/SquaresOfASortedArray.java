package com.littlefatz;


//https://leetcode-cn.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] A) {

        int length = A.length;
        int[] result = new int[length];
        int left = 0;
        int right = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            int leftValue = A[left] * A[left];
            int rightValue = A[right] * A[right];
            if (leftValue > rightValue) {
                left++;
                result[i] = leftValue;
            } else {
                right--;
                result[i] = rightValue;
            }

        }

        return result;
    }
}
