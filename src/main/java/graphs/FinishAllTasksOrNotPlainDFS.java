package graphs;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem 207 Course Schedule
 * https://leetcode.com/problems/course-schedule
 *
 * NOTE: WORKS  FUNCTIONALLY, BUT HANGS AS DATA SIZE GROWS. PERFORMANCE DEGRADATION IS EXPONENTIAL
 *
 * This problem translated to a directed graph. If a course 'i' is prerequisite for course 'j', we add an edge in DAG
 * from vertex i -> j. This way we construct a directed graph.
 *
 * The goal is to validate that there is no cycle in this directed graph. If a cycle exists, it is impossible to
 * complete all the tasks. It is not required that the graph should be connected. This is because some tasks may have
 * disconnected dependencies, as depicted below.
 *      a -> b -> c    e -> f   g -> h -> i
 *                              |         ^
 *                              |         |
 *                              +---------+
 *
 * The logic for cycle detected in DAG is standard. Start DFS from any vertex. In case we reach a vertex which had been
 * visited in the current traversal (recursion), we know a cycle exists. We also need to ensure that we visit all
 * vertices; for this we maintain a visited collection.
 *
 * Sample task / course DAGs:
 * GRAPH 1
 * =======
 *      1 -> 2 -> 3   4 -> 5   6 -> 7 -> 8
 *
 * GRAPH 2
 * =======
 *      1 -> 2 -> 3 -> 7   4 -> 5
 *           |        ^
 *           |        |
 *           +--> 6 --+
 *
 * GRAPH 3 : All tasks / courses can not be completed
 * =======
 *      1 -> 2 -> 3 -> 7   4 -> 5
 *           ^        |
 *           |        V
 *           +-- 6 --+
 *
 */
public class FinishAllTasksOrNotPlainDFS {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // 1. Prepare adjacency list for directed graph
        Map<Integer, List<Integer>> adj = toAdjacencyList(prerequisites);
        
        // 2. Visited collection
        boolean[] visited = new boolean[numCourses];
        
        // 3. Do DFS
        for(Integer v : adj.keySet()) { // iterate through all vertices
            if(visited[v]) { // if the vertex has already been visited, skip DFS
                continue;
            }
            if(isCycleFoundViaDFS(v, new boolean[numCourses], visited, adj)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isCycleFoundViaDFS(Integer v, boolean[] currRcrsnVisited, boolean[] visited,
                                       Map<Integer, List<Integer>> adj) {
        //System.out.printf( "{cur: %d, visited: %s} %n", v, Arrays.toString(visited) );
        //1. Recursion termination
        if(currRcrsnVisited[v]) {
            return true; // We detected a cycle
        }
    
        // Mark this vertex as visited
        currRcrsnVisited[v] = true;
        visited[v] = true;
        
        // Visit all neighbours
        boolean cycleFound;
        for(Integer neighbour : adj.get( v )) {
            cycleFound = isCycleFoundViaDFS(neighbour,currRcrsnVisited,visited,adj );
            currRcrsnVisited[neighbour] = false; // remove as we are done with visiting this node and back on `v'
            if(cycleFound){
                return true;
            }
        }
        return false;
    }
    
    private Map<Integer, List<Integer>> toAdjacencyList(int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] edge;
        int v1, v2; // vertices of an edge
        for(int i=0; i<prerequisites.length; i++) {
            edge = prerequisites[i];
            v2 = edge[0];
            v1 = edge[1];
            // Add edge in adj
            adj.putIfAbsent(v1, new LinkedList<>() );
            adj.putIfAbsent(v2, new LinkedList<>() );
            adj.get(v1).add(v2);
        }
        return adj;
    }

}
