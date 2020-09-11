package com.littlefatz;

//https://leetcode-cn.com/problems/subarray-sum-equals-k/
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int[] sum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int count = 0;
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (sum[i] - sum[j] == k) {
                    count++;
                }
            }

        }
        return count;
    }
}
