package com.littlefatz;

//https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int tempSum = numbers[left] + numbers[right];
            if (tempSum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (tempSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;

    }
}
