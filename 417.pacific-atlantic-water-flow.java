import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (42.38%)
 * Total Accepted:    98.2K
 * Total Submissions: 231K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a
 * cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 *
 * Note:
 *
 *
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *
 *
 *
 *
 * Example:
 *
 *
 * Given the following 5x5 matrix:
 *
 * ⁠ Pacific ~   ~   ~   ~   ~
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with
 * parentheses in above matrix).
 *
 *
 *
 *
 */
class Solution {

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		if (matrix.length == 0) {
			return new ArrayList<List<Integer>>();
		}

		int rows = matrix.length, cols = matrix[0].length;

		int[][] atlantic = new int[rows][cols];
		int[][] pacific = new int[rows][cols];

		// Top bottom
		for (int col = 0; col < cols; ++col) {
			dfs(matrix, 0, col, Integer.MIN_VALUE, pacific);
			dfs(matrix, rows - 1, col, Integer.MIN_VALUE, atlantic);
		}

		// left right
		for (int row = 0; row < rows; ++row) {
			dfs(matrix, row, 0, Integer.MIN_VALUE, pacific);
			dfs(matrix, row, cols - 1, Integer.MIN_VALUE, atlantic);
		}

		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

		for (int row = 0; row < rows; ++row) {
			for (int col = 0; col < cols; ++col) {
				if (pacific[row][col] == 1 && atlantic[row][col] == 1) {
					LinkedList<Integer> coords = new LinkedList<Integer>();
					coords.add(row);
					coords.add(col);
					res.add(coords);
				}
			}
		}

		return res;
	}

	public void dfs(int[][] matrix, int row, int col, int lastVal, int[][] ocean) {
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
			return;
		}
		if (matrix[row][col] < lastVal) {
			return;
		}
		if (ocean[row][col] == 1) {
			return;
		}

		ocean[row][col] = 1;

		dfs(matrix, row + 1, col, matrix[row][col], ocean);
		dfs(matrix, row - 1, col, matrix[row][col], ocean);
		dfs(matrix, row, col + 1, matrix[row][col], ocean);
		dfs(matrix, row, col - 1, matrix[row][col], ocean);
	}
}
