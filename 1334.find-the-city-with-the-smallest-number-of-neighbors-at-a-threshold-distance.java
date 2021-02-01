import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1334 lang=java
 *
 * [1334] Find the City With the Smallest Number of Neighbors at a Threshold Distance
 *
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
 *
 * algorithms
 * Medium (46.60%)
 * Total Accepted:    19.1K
 * Total Submissions: 40.9K
 * Testcase Example:  '4\n[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]\n4'
 *
 * There are n cities numbered from 0 to n-1. Given the array edges where
 * edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted
 * edge between cities fromi and toi, and given the integer distanceThreshold.
 *
 * Return the city with the smallest number of cities that are reachable
 * through some path and whose distance is at most distanceThreshold, If there
 * are multiple such cities, return the city with the greatest number.
 *
 * Notice that the distance of a path connecting cities i and j is equal to the
 * sum of the edges' weights along that path.
 *
 *
 * Example 1:
 *
 *
 *
 *
 * Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold =
 * 4
 * Output: 3
 * Explanation: The figure above describes the graph. 
 * The neighboring cities at a distanceThreshold = 4 for each city are:
 * City 0 -> [City 1, City 2] 
 * City 1 -> [City 0, City 2, City 3] 
 * City 2 -> [City 0, City 1, City 3] 
 * City 3 -> [City 1, City 2] 
 * Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we
 * have to return city 3 since it has the greatest number.
 *
 *
 * Example 2:
 *
 *
 *
 *
 * Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]],
 * distanceThreshold = 2
 * Output: 0
 * Explanation: The figure above describes the graph. 
 * The neighboring cities at a distanceThreshold = 2 for each city are:
 * City 0 -> [City 1] 
 * City 1 -> [City 0, City 4] 
 * City 2 -> [City 3, City 4] 
 * City 3 -> [City 2, City 4]
 * City 4 -> [City 1, City 2, City 3] 
 * The city 0 has 1 neighboring city at a distanceThreshold = 2.
 *
 *
 *
 * Constraints:
 *
 *
 * 2 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti, distanceThreshold <= 10^4
 * All pairs (fromi, toi) are distinct.
*
*
*/

// [Java] Dijkstra Algorithm / Floyd Warshall
//
// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/490331
//
// * Lang:    java
// * Author:  nihalanim9
// * Votes:   6


/* Dikstra Algorithm */
class Edge {
	int to;
	int weight;

	public Edge(int to, int weight){
		this.to = to;
		this.weight = weight;
	}
}

/* Dijkstra Algorithm */
class Solution {
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		// Create Linked list of edges as the vertex
		LinkedList<Edge>[] graph = new LinkedList[n];

		for(int i = 0; i < graph.length; i++){
			graph[i] = new LinkedList<>();
		}

		// Fill the matrix graph with bidirectional direct Edges
		for(int[] edge : edges){
			graph[edge[0]].add(new Edge(edge[1], edge[2]));	// from
			graph[edge[1]].add(new Edge(edge[0], edge[2]));	// to
		}

		int maxNodes = n + 1;
		int maxVertex = -1;
		for(int i = 0; i < n; i++){
			int visits = bfs(graph, i, distanceThreshold);
			if(visits <= maxNodes){
				maxVertex = i;
				maxNodes = Math.min(maxNodes, visits);
			}
		}

		return maxVertex;
	}

	// Breadth-first Search (BFS)
	// Returns the number of visited nodes
	public int bfs(LinkedList<Edge>[] graph, int vertex, int thresh){
		// Storage for the explored vertices
		Map<Integer,Integer> map = new HashMap<>();

		// (Edge a, Edge b) -> (a.weight - b.weight) is a comparator lambda for
		// sorting the smallest value (a.weight - b.weight) first. Therefore, this
		// PQ prioritizes smaller numbers first (ascending).
		PriorityQueue<Edge> pq = new PriorityQueue<>((Edge a, Edge b) -> (a.weight - b.weight));
		// Initialize with new Edge with 0 weight
		pq.offer(new Edge(vertex, 0));

		while(!pq.isEmpty()){
			Edge edge = pq.remove();

			// Skip if edge already in the map and weight is greater
			if(map.containsKey(edge.to) && edge.weight > map.get(edge.to))
				continue;

			// Add or update edge to map
			map.put(edge.to, edge.weight);

			// Traverse next edge
			for(Edge e : graph[edge.to]) {
				int dist = e.weight + edge.weight;

				if(dist > thresh)
					continue;

				// Skip if edge already in the map and distance is greater
				if(map.containsKey(e.to) && dist > map.get(e.to))
					continue;

				// Add or update edge to map
				map.put(e.to, dist);
				pq.offer(new Edge(e.to,dist));
			}
		}

		return map.size() - 1;
	}
}

// /* Floyd Warshall */
// class Solution {
// 	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
// 		// This needs to be a float because it needs to store the Integer.MAX_VALUE.
// 		// Else if this is int, adding a positive number to the max value an integer
// 		// can handle, the bits will overflow and becomes a negative number.
// 		// Alternatively, instead of the MAX_VALUE as a placeholder, since the
// 		// constraint for distanceThreshold <= 10^4, we can initialize it with
// 		// anything greater than the threshold value (i.e., 10001).
// 		float[][] dp = new float[n][n];
//
// 		// Initialize dp
// 		for (int i = 0; i < n; i++) {
// 			Arrays.fill(dp[i], Integer.MAX_VALUE);
// 			dp[i][i] = 0;
// 		}
//
// 		for (int[] edge : edges) {
// 			// Fill dp with from to edge grid; dp[from][to] = weight
// 			dp[edge[0]][edge[1]] = edge[2];
// 			dp[edge[1]][edge[0]] = edge[2];
// 		}
//
// 		// Find all shortest path
// 		for (int detour = 0; detour < n; detour++) {
// 			for (int from = 0; from < n; from++) {
// 				for (int to = 0; to < n; to++) {
// 					// Update edge path if detour city is shorter than direct
// 					if (dp[from][to] > dp[from][detour] + dp[detour][to])
// 						dp[from][to] = dp[from][detour] + dp[detour][to];
// 				}
// 			}
// 		}
//
// 		int maxVisits = n + 1;
// 		int cityWithLesserNeighbors = -1;
// 		for(int from = 0; from < n; from++) {
// 			// Get all neighboring cities with less than distanceThreshold edge
// 			int neighborCitiesWithinLimit = 0;
// 			for(int to = 0; to < n; to++) {
// 				if(dp[from][to] <= distanceThreshold)
// 					neighborCitiesWithinLimit++;
// 			}
// 			if(neighborCitiesWithinLimit <= maxVisits){
// 				cityWithLesserNeighbors = from;
// 				maxVisits = Math.min(maxVisits, neighborCitiesWithinLimit);
// 			}
// 		}
//
// 		return cityWithLesserNeighbors;
// 	}
// }
