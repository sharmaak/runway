package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * LeetCode problem 261 Graph Valid Tree
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a
 * function to check whether these edges make up a valid tree.
 *
 * Reference:
 * a) https://leetcode.ca/all/261.html
 * b) https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-bfs/
 *
 * An undirected graph is a valid tree iff
 * a) It is connected
 * b) It has no cycles
 */
public class LC261GraphValidTree {
    public boolean isGraphValidTree(int n, int[][] edges) {
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
        
        Set<Integer> visited = new HashSet<>();
        Integer[] parent = new Integer[n]; // to keep track of parents
        boolean cycleFound = false;
        // I prefer BFS over DFS due to it's real-life feasibility
        Queue<Integer> queue = new LinkedList<>();
        Integer aVertex = adj.keySet().iterator().next();
        queue.offer(aVertex);
        Integer current;
        while(queue.size() > 0 ) {
            current = queue.poll();
            if(visited.contains(current)) {
                cycleFound = true;
                break;
            }
            visited.add(current);
            for(Integer neighbour : adj.get(current)) {
                parent[neighbour] = current;
                if( !neighbour.equals(parent[current]) ) {
                    queue.offer( neighbour );
                }
            }
            
        }
        return !cycleFound && visited.size() == adj.keySet().size(); // all nodes has been visited => graph is connected
    }
}
