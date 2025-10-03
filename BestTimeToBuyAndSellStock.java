/*
Problem: Best Time to Buy and Sell Stock
Difficulty: Easy
Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

Approach 1: Brute Force
1. Try every pair (buy on day i, sell on day j where j > i).
2. Keep track of maximum profit.
3. Time Complexity: O(n^2)
4. Space Complexity: O(1)

Approach 2: Optimized (Single Pass)
1. Keep track of the minimum price seen so far.
2. For each price, calculate profit = current price - minimum price.
3. Update maximum profit if this profit is higher.
4. Time Complexity: O(n)
5. Space Complexity: O(1)
*/

public class BestTimeToBuyAndSellStock {

    // Approach 1: Brute Force
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    // Approach 2: Optimized (Single Pass)
    public int maxProfitOptimized(int[] prices) {
        int maximum_profit = 0;
        int minimum_price = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minimum_price){
                minimum_price = prices[i];
            }
            int current_profit = prices[i] - minimum_price;
            maximum_profit = Math.max(maximum_profit, current_profit);
        }
        return maximum_profit;
    }

    // Example test
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};

        System.out.println("Brute Force Profit: " + sol.maxProfitBruteForce(prices));
        System.out.println("Optimized Profit: " + sol.maxProfitOptimized(prices));
    }
}
