package graphs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode problem 310 Minimum Height Trees
 * References:
 *  a) https://www.geeksforgeeks.org/roots-tree-gives-minimum-height/
 *  b) https://kennyzhuang.gitbooks.io/algorithms-collection/content/minimum_height_trees.html
 *
 * Here we use a sort of modified Kahn's algo. We detect all leaf nodes (inDegree[i]==1) and then we keep removing them
 * from the graph. We keep on doing this till we have less than two nodes in graph.
 *
 * What we are doing here is we are moving in from the farthest vertices in a graph, till we hit the middle vertices.
 * If we have odd number of vertices in the longest path, we shall have one middle node which gives MHT.
 * If we have even number of vertices in the longest path, we shall have two middle nodes which gives MHT.
 *
 * Runtime Complexity: O(V+E)
 */
public class LC310MinimumHeightTrees {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LC310MinimumHeightTrees.class);
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 1. Convert to Adjacency List
        Map<Integer, List<Integer>> adj = toAdjacencyList(n, edges);
        
        // 2. Calculate in-degree for each vertex
        int[] inDegree = new int[n];
        for( List<Integer> vertices : adj.values() ) {
            for(Integer vertex : vertices) {
                inDegree[vertex]++;
            }
        }
        LOGGER.info("Derived in-degrees: {}", inDegree);
        
        // 3. Fly inward removing leaf nodes and decrementing in-degrees
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++) {
            if(inDegree[i] <= 1) { // is connected to only 1 or no vertex, hence leaf node.
                // inDegree[i] == 0 will handle case of graph with just one vertex.
                queue.offer(i);
            }
        }
        
        int verticesCount = adj.keySet().size();
        Integer leavesToRemoveCount, leaf;
        while(verticesCount > 2) {
            // We simulate removal of all leaf vertices
            leavesToRemoveCount = queue.size();
            verticesCount = verticesCount - leavesToRemoveCount;
            
            for(int i=0; i<leavesToRemoveCount; i++) {
                // remove leaf vertex
                leaf = queue.poll();
                for(Integer neighbour : adj.get(leaf)) {
                    adj.get(neighbour).remove(leaf);
                    // also reduce in-degree of each neighbour by 1
                    inDegree[neighbour] = inDegree[neighbour] - 1;
                    // After removal of current vertex, if neighbour has just 1 connection left,
                    // then it is a new leaf vertex. Hence add it to queue.
                    if(inDegree[neighbour] == 1) {
                        queue.offer(neighbour);
                    }
                }
                adj.remove(leaf);
            }
        }
        return new LinkedList<>(queue);
    }
    
    private Map<Integer, List<Integer>> toAdjacencyList(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<n; i++) {
            adj.put(i, new LinkedList<>());
        }
        
        int vertex1, vertex2;
        for(int i=0; i<edges.length; i++) {
            vertex1 = edges[i][0];
            vertex2 = edges[i][1];
            adj.get( vertex1 ).add( vertex2 );
            adj.get( vertex2 ).add( vertex1 );
        }
        
        return adj;
    }
}
