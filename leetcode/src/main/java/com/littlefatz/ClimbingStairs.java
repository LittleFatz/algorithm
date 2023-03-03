package com.littlefatz;


//https://leetcode-cn.com/problems/climbing-stairs/
//斐波那契数列    f（3） = f（1） + f（2）
//最近子问题


public class ClimbingStairs {

    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }


    public int climbStairs3(int n) {

        if (n <= 2) {
            return n;
        }

        int step1 = 1;
        int step2 = 2;
        int target = 3;
        int result = 0;
        while (target <= n) {
            result = step1 + step2;
            step1 = step2;
            step2 = result;
            target++;
        }

        return result;
    }

    public static void main(String[] args) {
        ClimbingStairs test = new ClimbingStairs();
        int result = test.climbStairs(3);
        System.out.println(result);

    }


    public int climbStairs4(int n) {
        if (n <= 2) {
            return n;
        }

        int result = 0;
        int step1 = 1;
        int step2 = 2;

        for (int i = 3; i <= n; i++) {
            result = (step1 + step2);
            step1 = step2;
            step2 = result;
        }

        return result;
    }

    public int numWays(int n) {

        if (n == 1 || n == 0) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int oneStep = 1;
        int twoStep = 2;

        int totalCount = 0;
        for (int i = 3; i <= n; i++) {
            totalCount = (oneStep + twoStep) % 1000000007;
            oneStep = twoStep;
            twoStep = totalCount;
        }

        return totalCount;

    }


    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int step1 = 1;
        int step2 = 2;
        int target = 3;
        int result = 3;
        while (target <= n) {
            result = step1 + step2;
            step1 = step2;
            step2 = result;
            target++;
        }

        return result;
    }






























}
