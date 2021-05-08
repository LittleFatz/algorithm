package com.littlefatz;

//https://leetcode-cn.com/problems/single-number
public class SingleNumber {

    public int singleNumber(int[] nums) {

        int single = 0;
        for (int num : nums) {
            single ^= num;
        }

        return single;
    }
}
