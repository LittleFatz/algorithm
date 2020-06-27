package com.littlefatz.binarysearch;

//https://leetcode-cn.com/problems/valid-perfect-square/
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            long midValue = (long) mid * (long) mid;
            if (midValue == num) {
                return true;
            } else if (midValue > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare test = new ValidPerfectSquare();
        System.out.println(test.isPerfectSquare(14));
    }
}
