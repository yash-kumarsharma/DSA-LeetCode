/*
 LeetCode 122: Best Time to Buy and Sell Stock II
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 Approach: Greedy (Accumulate all upward slopes) O(n)
*/

class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    // Utility to print result
    private static void printResult(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();
        int[] prices = {7,1,5,3,6,4};
        int result = solution.maxProfit(prices);
        printResult(result); // Output: 7
    }
}
