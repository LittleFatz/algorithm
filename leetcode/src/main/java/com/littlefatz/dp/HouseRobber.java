package com.littlefatz.dp;

//https://leetcode-cn.com/problems/house-robber/
public class HouseRobber {

//    public int rob(int[] nums) {
//
//        int length = nums.length;
//        if (length == 0) {
//            return 0;
//        } else if (length == 1) {
//            return nums[0];
//        }
//
//        int[] dp = new int[length];
//
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i< length; i++) {
//            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
//        }
//
//        return dp[length - 1];
//    }

    public static void main(String[] args) {
        HouseRobber test = new HouseRobber();
        int[] data = new int[]{2,7,9,3,1};
        System.out.println(test.rob(data));
    }


    public int rob2(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }

        /**
         * https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-dong-tai-gui-hua-jie-gou-hua-si-lu-/
         * 用 dp[i] 表示前 ii 间房屋能偷窃到的最高总金额
         * dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
         * 其实 i-1 未必被偷，dp[i-1]包含了两种情况：
         * i-1 被偷： 那符合上面我们定义的dp的预期
         * i-1没被偷：那么 dp[i-1]的值就是等于 dp[i-2]
         */
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[length - 1];
    }

    public int rob(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }


        int[] dp = new int[length + 1];
        dp[1] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }


        return dp[length];
    }






















}
