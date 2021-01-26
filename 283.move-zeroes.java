/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (58.47%)
 * Total Accepted:    1M
 * Total Submissions: 1.8M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 *
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */
class Solution {

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;

		// Find all non zero elements and shift them are the beginning of the array
		// in order, disregarding if will be duplicated
		//
		// Loop over array from the index adjacent to the last non-zero element from
		// the first loop, and fill those remaining elements with zeroes.
		//
		// Input: [0,1,0,3,12]
		//        [1,3,0,3,12]
		//        [1,3,12,0,12]
		//        [1,3,12,0,0]
		//        [1,3,12,0,0]

		int anchor = 0;

		for (int num : nums) {
			if (num != 0) nums[anchor++] = num;
		}

		while (anchor < nums.length) {
			nums[anchor++] = 0;
		}
	}

	// First working solution (SLOWER)

	// public void moveZeroes(int[] nums) {
	// 	// Notes:
	// 	//   Zeroes are scattered everywhere
	// 	//   Modify array in place
	// 	//
	// 	// Input: [0,1,0,3,12]
	// 	//        [1,0,0,3,12]
	// 	//        [1,3,0,0,12]
	// 	//        [1,3,12,0,0]
	//
	// 	// Loop over the array
	// 		// Check if current value is 0
	// 			// Loop over the array from current position until a non-zero element
	// 			// has been found
	// 				// Swap the current value from outer loop with the non-zero element
	// 				// found in the inner loop
	//
	// 	for (int i = 0; i < nums.length - 1; i++) {
	// 		int cur = nums[i];
	//
	// 		if (cur == 0) {
	//
	// 			for (int j = i + 1; j < nums.length; j++) {
	// 				if (nums[j] != 0) {
	// 					nums[i] = nums[j];
	// 					nums[j] = cur;
	// 					break;
	// 				}
	// 			}
	// 		}
	// 	}
	//
	// }
}
