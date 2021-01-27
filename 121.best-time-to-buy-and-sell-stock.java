/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * algorithms
 * Easy (51.34%)
 * Total Accepted:    1.2M
 * Total Submissions: 2.2M
 * Testcase Example:  '[7,1,5,3,6,4]'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 *
 *
 * Example 1:
 *
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit
 * = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you
 * must buy before you sell.
 *
 *
 * Example 2:
 *
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit =
 * 0.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 *
 *
 */
class Solution {
	public int maxProfit(int[] prices) {
		// Given information:
		//    Must buy before selling
		//    Theres no transaction if the array is sorted in descending order
		//    Theres always at least 1 element in the array
		//    Prices will never be negative

		// Create a dynamic buying indicator variable
		// Loop over the array, updating the buy variable as a better buying price
		// present itself.
		// If theres a selling oppportunity, try to update profits if its greater
		// than the existing.
		//
		// Would it benefit me to have two pointers?
		// Yes
		//
		// Input: [7,1,5,4]
		//         ^ <- buy
		//        [7,1,5,4]
		//           ^
		//        [7,1,5,4]
		//             ^ <- sell (profit = 4)
		//        [7,1,5,4]
		//               ^

		int profit = 0;
		int buy = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			int curr = prices[i];
			// Look for a lower price point for buying
			if (curr < buy) {
				buy = curr;
			} else {
				profit = Math.max(profit, curr - buy);
			}
		}

		return profit;
	}
}







