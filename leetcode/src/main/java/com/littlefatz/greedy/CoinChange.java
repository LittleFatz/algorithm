package com.littlefatz.greedy;

// https://leetcode-cn.com/problems/coin-change/
public class CoinChange {

//    private int[] count;

    public int coinChange2(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }

        count = new int[amount];
        return getMinCoin(coins, amount);

    }

    private int getMinCoin2(int[] coins, int remain) {

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
            int min = getMinCoin2(coins, remain - coinValue);
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

    private int[] count;

    public int coinChange(int[] coins, int amount) {

        count = new int[amount + 1];
        getMinCoin(coins, amount);
        return count[amount];
    }

    private int getMinCoin(int[] coins, int remain) {

        if (remain < 0) {
            return -1;
        }

        if (remain == 0) {
            return 0;
        }

        if (count[remain] != 0) {
            return count[remain];
        }

        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp = getMinCoin(coins, remain - coin);
            if (temp != -1 && (temp + 1) < minCount) {
                minCount = temp + 1;
            }
        }

        if (minCount == Integer.MAX_VALUE) {
            count[remain] = -1;
        } else {
            count[remain] = minCount;
        }

        return count[remain];
    }
}
