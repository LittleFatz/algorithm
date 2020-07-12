package com.littlefatz.dp;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class BestTimeToBuySellStockWithFee {

    public int maxProfit(int[] prices, int fee) {

        int dpI0 = 0;
        int dpI1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int temp = dpI0;//
            dpI0 = Math.max(dpI0, dpI1 + price );
            dpI1 = Math.max(dpI1, temp - price - fee);//这个fee如果放到dpI0的更新操作中，有可能超出取值范围
        }

        return dpI0;

    }

    public static void main(String[] args) {
        BestTimeToBuySellStockWithFee test = new BestTimeToBuySellStockWithFee();
        int[] data = new int[]{1,3,2,8,4,9};
        System.out.println(test.maxProfit(data, 2));
    }
}
