package com.littlefatz;

//https://leetcode-cn.com/problems/power-of-two/https://leetcode-cn.com/problems/power-of-two/
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {


        if (n == 0) {
            return false;
        }

        long x = (long)n;

        return (x & (x-1)) == 0;
    }
}


