package com.littlefatz.binarysearch;

//https://leetcode-cn.com/problems/sqrtx/
public class Sqrtx {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midValue = (long)mid * (long)mid;//注意整型的取值范围

            //因为返回值需要向下取整，所以把小于和等于作为一类处理
            if (midValue <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Sqrtx test = new Sqrtx();
        System.out.println(test.mySqrt(2147395599));
    }
}
