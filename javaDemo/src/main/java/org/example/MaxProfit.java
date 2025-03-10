package org.example;

/**
 * @author xianr
 * @date 2023-09-09
 * @Description 动态规划 求股票的最大利润
 */
public class MaxProfit {

    /**
     * 方法1 暴力破解
     */
    static void maxProfit1(int[] prices){

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i];
                    if (maxProfit < profit) {
                        maxProfit = profit;
                    }
                }
            }
        }
        System.out.println(maxProfit);
    }

    static void maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                maxProfit = 0;
            }else {
                int profit = prices[i] - minPrice;
                if (maxProfit < profit) {
                    maxProfit = prices[i] - minPrice;
                }
            }

        }
        System.out.println(maxProfit);
    }



    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        maxProfit1(arr);
        maxProfit2(arr);

    }
}
