package com.littlefatz;


//https://leetcode-cn.com/problems/number-of-digit-one/
public class NumberOfDigitOne {

    public int countDigitOne(int n) {

        int counter = 0;

        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            counter += (n / divider) * i + Math.min(Math.max(n % divider -i + 1, 0), i);
        }

        return counter;
    }
}
