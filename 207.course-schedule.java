import java.util.ArrayList;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (44.27%)
 * Total Accepted:    536.4K
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i]
 * = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 *
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 *
 *
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 * Example 1:
 *
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 *
 * Example 2:
 *
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should also have finished course 1. So it is impossible.
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= numCourses <= 10^5
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 *
 *
 */

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// Given infos
		//
		// prerequisites[] is the target class
		// prerequisites[][] are the dependency classes

		if (numCourses <= 1) {
			return true;
		}

		ArrayList<Integer>[] graph = new ArrayList[numCourses];
		// 0 = unvisited
		// 1 = visited (but not all dependency nodes explored)
		// 2 = completed (visited and all dependency nodes explored)
		int[] visited = new int[numCourses];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int[] pre : prerequisites) {
			graph[pre[0]].add(pre[1]);
		}

		for (int i = 0; i < numCourses; ++i) {
			if (!dfs(graph, i, visited)) {
				return false;
			}
		}

		return true;
	}

	public boolean dfs(ArrayList<Integer>[] graph, int course, int[] visited) {
		// Cycle detected
		if (visited[course] == 1) {
			return false;
		} else if (visited[course] == 2) {
			return true;
		}

		visited[course] = 1;

		for (int i = 0; i < graph[course].size(); ++i) {
			if (!dfs(graph, graph[course].get(i), visited)) {
				return false;
			}
		}

		visited[course] = 2;
		return true;
	}
}
