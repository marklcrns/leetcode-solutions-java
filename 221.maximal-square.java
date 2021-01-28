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

class Solution {
	public int maximalSquare(char[][] matrix) {
		int maxRow = matrix.length, maxCol = maxRow > 0 ? matrix[0].length : 0;
		int maxSqrLen = 0;
		for (int row = 0; row < maxRow; row++) {
			for (int col = 0; col < maxCol; col++) {

				// Check for the maximum square size relative to current element
				// 1 - > ?
				// |
				// v
				// ?
				// Searching from left to right and top to bottom
				if (matrix[row][col] == '1') {
					int sqrLen = 1;
					boolean isExpandSquare = true;

					// If square is expandable or not at the lower edge and/or right edge
					// of the matrix
					while (sqrLen + row < maxRow && sqrLen + col < maxCol && isExpandSquare) {

						// Look for zero horizontally for expansion
						for (int i = col; i <= sqrLen + col; i++) {
							if (matrix[row + sqrLen][i] == '0') {
								isExpandSquare = false;
								break;
							}
						}

						// Look for zero vertically for expansion
						for (int i = row; i <= sqrLen + row; i++) {
							if (matrix[i][col + sqrLen] == '0') {
								isExpandSquare = false;
								break;
							}
						}

						if (isExpandSquare)
							sqrLen++;
					}

					if (maxSqrLen < sqrLen) {
						maxSqrLen = sqrLen;
					}
				}
			}
		}
		return maxSqrLen * maxSqrLen;
	}
}



// class Solution {
// 	public int maximalSquare(char[][] matrix) {
// 		// Check if matrix is empty
// 		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
// 		// Notes:
// 			// 1's ands 0's are in Char format?
//
// 		// [["1","0","1","0","0"]
// 		//  ["1","0","1","1","1"]
// 		//  ["1","1","1","1","1"]
// 		//  ["1","0","0","1","0"]]
// 		//
// 		// [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//
// 		// Approach:
// 		// BRUTE FORCE:
// 			// Loop over matrix m x n
// 				// Check bottom row and right column for 1's
// 					// Create a function for checking for surrounding 1's and 0's
// 				// if (all 1's)
// 					// updateArea;
// 				// if (bottom row || right col nomore)
// 					// break
//
// 		// Right and bottom search
//
// 		// First check if current index is 1, otherwise return 0
// 		// Check if next nth binary is 1, if so, check the next nth, while recording
// 		// how far it went so far. (this will be used how far to search mth wise or
// 		// vertically)
// 		// When it horizontal search reaches the closest zero break and go to the
// 		// next mth and repeat certain times the furthest horizontal search reached
//
// 		// at the end, get the minimum value of the horizontal searches to get the
// 		// biggest area of the matrix at the given start location
//
// 		int rowMax = matrix.length;
// 		int colMax = matrix[0].length;
// 		int maxSquareSide = 0;
// 		for (int row = 0; row < rowMax - 1; row++) {		// Exclude last row and col
// 			for (int col = 0; col < colMax - 1; col++) {
//
// 				// find furthest non 0 from the right
// 				int furthestNonZeroSubCol = findFurthestNonZeroSubCol(matrix, row, col, colMax);
// 				maxSquareSide = Math.max(maxSquareSide,
// 						evaluateOneSquare(matrix, row, col, furthestNonZeroSubCol));
//
// 			}
// 		}
// 	}
//
// 	public int findFurthestNonZeroSubCol(char[][] matrix, int row, int col, int colMax) {
// 		int furthestNonZeroSubCol = 0;
// 			for (int i = col; i < colMax; i++) {
// 				if (matrix[row][i] == '0') break;
// 				else furthestNonZeroSubCol++;
// 			}
// 		return furthestNonZeroSubCol;
// 	}
//
// 	public int evaluateOneSquare(char[][] matrix, int row, int col, int size) {
// 		while (++row <= size) {
// 			int furthestNonZeroSubCol = findFurthestNonZeroSubCol(matrix, row, col, size);
// 			if (furthestNonZeroSubCol <= size)
// 				continue;
// 		}
// 	}
// }
