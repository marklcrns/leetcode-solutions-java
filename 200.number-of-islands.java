/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (48.72%)
 * Total Accepted:    956.8K
 * Total Submissions: 2M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the
 * number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 *
 * Example 2:
 *
 *
 * Input: grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 *
 * Constraints:
 *
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 *
 */


// public class Solution {
//
// 	private int n;
// 	private int m;
//
// 	public int numIslands(char[][] grid) {
// 		int count = 0;
// 		n = grid.length;
// 		if (n == 0) return 0;
// 		m = grid[0].length;
// 		for (int i = 0; i < n; i++){
// 			for (int j = 0; j < m; j++) {
// 				if (grid[i][j] == '1') {
// 					DFSMarking(grid, i, j);
// 					++count;
// 				}
// 			}
// 		}
// 		return count;
// 	}
//
// 	private void DFSMarking(char[][] grid, int i, int j) {
// 		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
// 		grid[i][j] = '0';
// 		DFSMarking(grid, i + 1, j);
// 		DFSMarking(grid, i - 1, j);
// 		DFSMarking(grid, i, j + 1);
// 		DFSMarking(grid, i, j - 1);
// 	}
// }

class Solution {

	private int W;
	private int H;

	public int numIslands(char[][] grid) {

		W = grid.length;
		H = grid[0].length;

		if (W == 0) return 0;

		int islands = 0;
		for (int i = 0; i < W; ++i) {
			for (int j = 0; j < H; ++j) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					++islands;
				}
			}
		}
		return islands;
	}

	public void dfs(char[][] grid, int x, int y) {
		if (isOutOfBounds(grid, x, y) || grid[x][y] != '1') return;
		grid[x][y] = '0';
		dfs(grid, x, y + 1); // top
		dfs(grid, x + 1, y); // right
		dfs(grid, x, y - 1); // down
		dfs(grid, x - 1, y); // left
	}

	public boolean isOutOfBounds(char[][] grid, int x, int y) {
		if (x < 0 || y < 0 || x >= W || y >= H)
			return true;

		return false;
	}
}
