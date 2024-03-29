package com.littlefatz.dp;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

//https://leetcode-cn.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    public int lengthOfLIS2(int[] nums) {

        int length = nums.length;
        if (length <= 1) {
            return length;
        }

        int[] dp = new int[length];

        int result = 1;
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public int lengthOfLIS3(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >=0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
        }
        int result = 0;
        for (int value : dp) {
            result = Math.max(result, value);
        }

        return result;
    }


    public int lengthOfLIS(int[] nums) {

        int length = nums.length;
        if (length <= 1) {
            return length;
        }

        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int value : dp) {
            result = Math.max(result, value);
        }
        return result;
    }


    public static String convertByteArraysToBinary(byte[] input) {
        final StringBuilder result = new StringBuilder();
        for (byte b : input) {
            int val = b; // byte -> int
            for (int i = 0; i < 8; i++) {
                result.append((val & 128) == 0 ? 0 : 1);      // 128 = 1000 0000
                val <<= 1;
            }
        }
        return result.toString();
    }

    public static String binaryUnicodeToString(String binary) {

        byte[] array = ByteBuffer.allocate(4).putInt(   // 4 bytes byte[]
                Integer.parseInt(binary, 2)
        ).array();

        return new String(array, StandardCharsets.UTF_8);
    }












}
