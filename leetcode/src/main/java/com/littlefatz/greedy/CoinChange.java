package com.littlefatz.greedy;

// https://leetcode-cn.com/problems/coin-change/
public class CoinChange {

    private int[] count;

    public int coinChange(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }

        count = new int[amount];
        return getMinCoin(coins, amount);

    }

    private int getMinCoin(int[] coins, int remain) {

        if (remain < 0) {
            return -1;
        }
        if (remain == 0) {
            return 0;
        }
        if (count[remain - 1] != 0) {
            return count[remain - 1];
        }

        int minCount = Integer.MAX_VALUE;
        for (int coinValue : coins) {
            int min = getMinCoin(coins, remain - coinValue);
            if (min < minCount && min != -1) {
                minCount = min + 1;
            }
        }

        if (minCount == Integer.MAX_VALUE) {
            count[remain - 1] = -1;
        } else {
            count[remain - 1] = minCount;
        }

        return count[remain - 1];
    }

    public static void main(String[] args) {
        int[] data = new int[]{2};
        int amount = 3;

        CoinChange test = new CoinChange();
        System.out.println(test.coinChange(data, amount));
    }
}
