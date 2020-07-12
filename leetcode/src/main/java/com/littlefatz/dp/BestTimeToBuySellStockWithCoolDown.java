package com.littlefatz.dp;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BestTimeToBuySellStockWithCoolDown {

    public int maxProfit(int[] prices) {

        int dpPre0 = 0;
        int dpPre1 = Integer.MIN_VALUE;
        int dpPrePre0 = 0;//dp[i-2]

        /**
         *  这里dpPrePre0的交换可以这样理解：
         *  假设现在是第n次循环，这时dpPre0其实是dp[i-1][0]，那么temp是dp[i-1][0]
         *  之后dpPre0更新为dp[i][0]，dpPrePre0为dp[i-1][0]
         *  进入第n+1次循环，temp=dp[i][0]，这时候dpPrePre0还是等于dp[i-1][0]，
         *  因此参与到dpPre1（即dp[i+1][1]）运算中,dpPrePre0的值是dp[i-1][0]
         */
        for (int price : prices) {
            int temp = dpPre0;
            dpPre0 = Math.max(dpPre0, dpPre1 + price);
            dpPre1 = Math.max(dpPre1, dpPrePre0 - price);
            dpPrePre0 = temp;

        }

        return dpPre0;

    }

    public static void main(String[] args) {
        BestTimeToBuySellStockWithCoolDown test = new BestTimeToBuySellStockWithCoolDown();
        int[] data = new int[]{1,2,3,0,2};
        System.out.println(test.maxProfit(data));
    }
}
