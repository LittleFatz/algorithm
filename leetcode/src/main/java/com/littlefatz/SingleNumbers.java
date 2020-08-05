package com.littlefatz;

//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        int divide = 1;
        while ((divide & sum) == 0) {
            divide <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & divide) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }

        }

        return new int[]{a, b};
    }
}
