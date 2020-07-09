package com.littlefatz.dp;

//https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
public class TranslateNumber {

    public int translateNum(int num) {

        String number = String.valueOf(num);
        int length = number.length();
        if (length < 2) {
            return 1;
        }

        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        char[] numberArray = number.toCharArray();
        for (int i = 1; i < length; i++) {
            dp[i + 1] = dp[i];
            int temp = 10 * (numberArray[i - 1] - '0') + (numberArray[i] - '0');
            if (temp >= 10 && temp <=25) {
                dp[i + 1] += dp[i - 1];
            }
        }

        return dp[length];

    }

    public static void main(String[] args) {
        TranslateNumber test = new TranslateNumber();
        System.out.println(test.translateNum(12258));
    }
}
