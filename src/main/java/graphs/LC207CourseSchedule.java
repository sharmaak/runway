package graphs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode problem 207 Course Schedule
 * Reference: Khan's algorithm: https://www.educative.io/edpresso/what-is-topological-sort
 *
 * This class uses Kahn's Algo to determine Topological Order of tasks. It inherently detects if the directed-graph
 * has a cycle. Kahn's algo uses BFS and solves the problem in O(V+E) runtime complexity.
 */
public class LC207CourseSchedule {
    
    private static final Logger LOGGER = LoggerFactory.getLogger( LC207CourseSchedule.class );
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // 1. Prepare adjacency list for directed graph
        Map<Integer, List<Integer>> adj = toAdjacencyList(prerequisites);
        
        // 2. Calculate in-degree for all vertices
        int[] inDegree = new int[numCourses];
        //The following iteration could have been over entrySet, but iterated over keys to maintain the obviousness.
        for(Integer vSource : adj.keySet()) {
            for(Integer vDestination : adj.get(vSource)) {
                inDegree[vDestination] = inDegree[vDestination] + 1;
            }
        }
        LOGGER.info( "Calculated inDegrees: {}", Arrays.toString(inDegree));
    
        // 3. Iterate over all nodes with in-degree = 0. Because there are source nodes (all its edges going away)
        Queue<Integer> queue = new LinkedList<>();
        for(Integer vertex : adj.keySet()) {
            
            // Add all nodes with in-degree = 0 in queue in one shot.
            if(inDegree[vertex] == 0) {
                queue.offer(vertex);
            }
        }
        for(Map.Entry e : adj.entrySet()) {}
        // If the directed-graph does not contain any cycles, then all the tasks / courses can be completed.
        return !isDirectedGraphContainsCycle( queue, inDegree, adj );
    }
    
    /**
     * Performs topological sort using Kahn's algorithm to see if cycle exists in directed graph.
     *
     * @param queue Queue for BFS
     * @param inDegree Array containing calculated in-degrees for all vertices
     * @param adj Adjacency list representation of graph
     * @return True iff graph contains at-least one cycle, false otherwise.
     */
    private boolean isDirectedGraphContainsCycle(Queue<Integer> queue, int[] inDegree,
                                                 Map<Integer, List<Integer>> adj) {
        int visited = 0; // Keeps track of vertices visited in BFS
        int[] topologicalSortResult = new int[adj.keySet().size()]; // stores result for topological sort
        Integer current;
        while((current = queue.poll()) != null) { // queue has elements
    
            // 4. Add the current vertex to topologically sorted vertices result.
            topologicalSortResult[visited] = current;
            
            // 5. Increment the visited node counter as we visited current node
            visited++;
            
            // 6. Enqueue the neighboring vertices with the in-degree of 0.
            //    Go through all neighbours of the current node and decrement their in-degree by one. Effectively, this
            //    depicts the structure of graph if current vertex is removed from graph.
            for(Integer neighbour : adj.get(current)) {
                inDegree[neighbour] = inDegree[neighbour] - 1;
                
                // If upon removal of current vertex, neighbour becomes a source-node, enqueue the neighbour
                if(inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        
        LOGGER.info("Vertices Count: {}, Visited: {}", adj.keySet().size(), visited);
        LOGGER.info("Topological sort result: {}",
                    visited == adj.keySet().size() ? Arrays.toString( topologicalSortResult ) : "Graph has cycle.");
        // 7. Validate the result. The number of visited vertices should be same as total-vertices in the graph.
        //    If this condition not met, the graph contains a cycle and can not have a topological sort.
        return visited != adj.keySet().size();
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
