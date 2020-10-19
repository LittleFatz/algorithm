package com.littlefatz.dp;

import java.util.Arrays;

//https://leetcode-cn.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {


    /**
     * 动态规划思想
     * dp[i][j] 表示将数组的前 i 个数分割为 j 段所能得到的最大连续子数组和的最小值
     * 第 j 段的具体范围，即我们可以枚举 k，其中前 k 个数被分割为 j−1 段，而第 k+1 到第 i 个数为第 j 段
     *
     * 时间复杂度：O(n^2 \times m)O(n
     * 2
     *  ×m)
     *  ×m)，其中 nn 是数组的长度，mm 是分成的非空的连续子数组的个数。总状态数为 O(n \times m)O(n×m)，状态转移时间复杂度 O(n)O(n)，所以总时间复杂度为 O(n^2 \times m)O(n
     * 2
     *  ×m)。
     *
     * 空间复杂度：O(n \times m)O(n×m)，为动态规划数组的开销。

     */

    public int splitArray2(int[] nums, int m) {
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
                 * k 需要从 0 开始：因为当 j = 1 的时候，意味着前面 i 个元素会被划分成同一段，那么 k 不能包含元素，所以等于 0
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

    public int splitArray3(int[] nums, int m) {

        int length = nums.length;
        int[][] dp = new int[length+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int[] sum = new int[length+1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        dp[0][0] = 0;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i;k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sum[i] - sum[k]));
                }
            }
        }

        return dp[length][m];

    }

    //二分查找
    public int splitArray(int[] nums, int m) {
        int left = getMax(nums);
        int right = getSum(nums);

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int count = getGroupCount(nums, middle);
            if (count == m) {
                right = middle - 1;
            } else if (count > m) {
                left = middle + 1;
            } else if (count < m) {
                right = middle - 1;
            }
        }

        return left;

    }

    private int getGroupCount(int[] nums, int max) {

        int sum = 0;
        int count = 1;
        for (int num : nums) {
            if (sum + num <= max) {
                sum += num;
            } else {
                count++;
                sum = num;
            }
        }
        return count;

    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }




}
