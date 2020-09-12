package com.littlefatz.dp;

//https://leetcode-cn.com/problems/counting-bits/description/
public class CountBits {

    /**
     * 通过分析 x 和 x/2 的关系，然后推导 dp 转移方程
     */
    public int[] countBits(int num) {

        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }
}
