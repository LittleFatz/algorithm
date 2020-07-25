package com.littlefatz.dp;

import java.util.Arrays;

//https://leetcode-cn.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int length = nums.length;
        int[][] dp = new int[length+1][m+1];

        for (int i = 0; i <= length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        //后面通过相减，就能获得元素 k+1 到 i 的总和
        int[] sub = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }

        dp[0][0] = 0;

        for (int i = 1; i <= length; i++) {

            /**
             * j <= Math.min(i, m)
             * 因为有可能出现一种情况，例如 m = 5，i = 3， 3个元素无法分成5段，因此只能取最小值
             */
            for (int j = 1; j <= Math.min(i, m); j++) {

                /**
                 * k需要从0开始：因为当 j = 1 的时候，意味着前面i个元素会被划分成同一段，那么k不能包含元素，所以等于0
                 */
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }

        return dp[length][m];

    }

    public static void main(String[] args) {
        int[] data = new int[]{7,2,5,10,8};
        SplitArrayLargestSum test = new SplitArrayLargestSum();
        System.out.println(test.splitArray(data,2));
    }
}
