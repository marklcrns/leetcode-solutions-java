/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (38.85%)
 * Total Accepted:    326.7K
 * Total Submissions: 840.2K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest
 * square containing only 1's and return its area.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 *
 *
 * Example 2:
 *
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 *
 *
 * Example 3:
 *
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 *
 *
 * Constraints:
 *
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 *
 *
 */

// BETTER DYNAMIC PROGRAMMING
// TIME: O(mn)
// SPACE: O(n)
// --------------------------
class Solution {
	public int maximalSquare(char[][] matrix) {
		int maxRow = matrix.length;
		int maxCol = maxRow > 0 ? matrix[0].length : 0;

		// Instead of alternate matrix, we use an array instead since we only need
		// to know the top left element from the current (which is the top row) per
		// row iteration
		int[] dp = new int[maxCol + 1];
		int maxSqrLen = 0, prev = 0;

		// Start loop from the top left of the matrix
		for (int row = 1; row <= maxRow; row++) {
			for (int col = 1; col <= maxCol; col++) {
				int next = dp[col];
				//  pre
				//   v
				//   S [ 0 , 0 , 0 , 0 , 0 ]
				//	     ^   ^
				//      c-1 nxt
				//
				if (matrix[row - 1][col - 1] == '1') {
					dp[col] = Math.min(Math.min(dp[col - 1], prev), next) + 1;

					maxSqrLen = Math.max(maxSqrLen, dp[col]);
				} else {
					dp[col] = 0;
				}
				prev = next;
			}
		}
		return maxSqrLen * maxSqrLen;
	}
}



// DYNAMIC PROGRAMMING
// TIME: O(mn)
// SPACE: O(mn)
// -------------------
// class Solution {
// 	public int maximalSquare(char[][] matrix) {
// 		int maxRow = matrix.length;
// 		int maxCol = maxRow > 0 ? matrix[0].length : 0;
// 		// dp = separate matrix for mapping dynamic programming values
// 		// +1 row and col for padding
// 		int[][] dp = new int[maxRow + 1][maxCol + 1];
// 		int maxSqrLen = 0;
// 		// Start loop from the top left of the matrix down to the bottom right
// 		// Starting from the second row and col, hence the padding
// 		for (int row = 1; row <= maxRow; row++) {
// 			for (int col = 1; col <= maxCol; col++) {
// 				// The the current element in matrix if 1
// 				if (matrix[row - 1][col - 1] == '1'){
// 					// dp values will eventually be filled up as the loop progresses, so
// 					// initially, the top and/or left of current dp matrix point will be
// 					// the default value of initialized int array, that is 0
// 					int topLeft = dp[row - 1][col - 1];
// 					int top = dp[row - 1][col];
// 					int left = dp[row][col - 1];
// 					dp[row][col] = Math.min(Math.min(left, top), topLeft) + 1;
// 					maxSqrLen = Math.max(maxSqrLen, dp[row][col]);
// 				}
// 			}
// 		}
// 		return maxSqrLen * maxSqrLen;
// 	}
// }



// BRUTE FORCE SOLUTION
// TIME: O((mn)^2)
// SPACE: O(1)
// --------------------
// class Solution {
// 	public int maximalSquare(char[][] matrix) {
// 		int maxRow = matrix.length, maxCol = maxRow > 0 ? matrix[0].length : 0;
// 		int maxSqrLen = 0;
// 		for (int row = 0; row < maxRow; row++) {
// 			for (int col = 0; col < maxCol; col++) {
//
// 				// Check for the maximum square size relative to current element
// 				// 1 - > ?
// 				// |
// 				// v
// 				// ?
// 				// Searching from left to right and top to bottom
// 				if (matrix[row][col] == '1') {
// 					int sqrLen = 1;
// 					boolean isExpandSquare = true;
//
// 					// If square is expandable or not at the lower edge and/or right edge
// 					// of the matrix
// 					while (sqrLen + row < maxRow && sqrLen + col < maxCol && isExpandSquare) {
//
// 						// Look for zero horizontally for expansion
// 						for (int i = col; i <= sqrLen + col; i++) {
// 							if (matrix[row + sqrLen][i] == '0') {
// 								isExpandSquare = false;
// 								break;
// 							}
// 						}
//
// 						// Look for zero vertically for expansion
// 						for (int i = row; i <= sqrLen + row; i++) {
// 							if (matrix[i][col + sqrLen] == '0') {
// 								isExpandSquare = false;
// 								break;
// 							}
// 						}
//
// 						if (isExpandSquare)
// 							sqrLen++;
// 					}
//
// 					// Record sqrLen if bigger than current
// 					if (maxSqrLen < sqrLen) {
// 						maxSqrLen = sqrLen;
// 					}
// 				}
// 			}
// 		}
// 		return maxSqrLen * maxSqrLen;
// 	}
// }

