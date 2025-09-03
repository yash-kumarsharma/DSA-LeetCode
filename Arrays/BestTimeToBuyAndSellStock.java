/*
 LeetCode 121: Best Time to Buy and Sell Stock
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 Approach: One Pass (Track min price & max profit) O(n)
*/

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        int result = solution.maxProfit(prices);
        printResult(result); // Output: 5
    }
}
