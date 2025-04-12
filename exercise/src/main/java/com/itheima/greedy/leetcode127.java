package com.itheima.greedy;

public class leetcode127 {
    public int maxProfit(int[] prices) {

        if(prices.length == 0){
            return 0;
        }

        int buy  = -prices[0];
        int sell = 0;

        for(int i = 1; i < prices.length; i++){
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, prices[i] + buy);
        }

        return sell;
    }
}
