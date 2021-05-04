package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode problem 323 Number of Connected Components in an Undirected Graph
 *
 * Reference:
 * a) https://leetcode.ca/all/261.html
 * b) https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-bfs/
 *
 */
public class LC323NumberOfConnectedComponentsInUndirectedGraph {
    public int calculateConnectedComponents(int n, int[][] edges) {
        // Edge cases
        // 1. 0 nodes
        // 2. 1 node
        
        //1. Convert to adjacency list
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int v=0; v<n; v++) {
            adj.put( v, new HashSet<>() );
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int counter = 0;
        for(int i=0; i<n; i++) {
            if( !visited[i]) {
                dfs(i, null, visited, adj);
                counter++;
            }
        }
        return counter;
    }
    
    private void dfs(Integer current, Integer parent, boolean[] visited, Map<Integer, Set<Integer>> adj) {
        if(visited[current]) { return; } // protection against loops
        // mark visited
        visited[current] = true;
        // dive deeper
        for(Integer neighbour : adj.get(current)) {
            if( !neighbour.equals(parent) ) {
                dfs(neighbour, current, visited, adj);
            }
            
        }
    }
}
