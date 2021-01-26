/*
 * @lc app=leetcode id=1200 lang=java
 *
 * [1200] Minimum Absolute Difference
 *
 * https://leetcode.com/problems/minimum-absolute-difference/description/
 *
 * algorithms
 * Easy (66.84%)
 * Total Accepted:    54.6K
 * Total Submissions: 81.7K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Given an array of distinct integers arr, find all pairs of elements with the
 * minimum absolute difference of any two elements. 
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair
 * [a, b] follows
 *
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in
 * arr
 *
 *
 *
 * Example 1:
 *
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with
 * difference equal to 1 in ascending order.
 *
 * Example 2:
 *
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 *
 *
 * Example 3:
 *
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 *
 */
class Solution {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(arr);

		// Get the maximum integer to ensure first mindif will be registered
		int minDif = Integer.MAX_VALUE;

		// Since the array will be sorted, looping over the array without nesting is
		// enough because the values are contiguously smallest diff

		for (int i = 0; i < arr.length - 1; i++) {
			int a = arr[i];
			int b = arr[i + 1];
			int dif = b - a;

			if (dif < minDif) {
				// Reset list since new minDif is found
				minDif = dif;
				list.clear();
				list.add(Arrays.asList(a , b));
			} else if (dif == minDif) {
				// Add to list
				list.add(Arrays.asList(a, b));
			}
		}

		return list;
	}
}
