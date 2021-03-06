package com.littlefatz.dp;

//https://leetcode-cn.com/problems/maximum-subarray/
public class MaximumSubarray {

    //dp[i]表示包含nums[i]在内的最大子序列和
    public int maxSubArray3(int[] nums) {

        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;

    }

    //优秀题解
    public int maxSubArray2(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] data = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray test = new MaximumSubarray();
        System.out.println(test.maxSubArray(data));


    }

    public int maxSubArray4(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            int total = dp[i-1] + nums[i];
            if (total > nums[i]) {
                dp[i] = total;
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxSubArray5(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;


    }






    public int maxSubArray(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
