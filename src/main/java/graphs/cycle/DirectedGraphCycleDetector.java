package graphs.cycle;

import graphs.ds.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class DirectedGraphCycleDetector<T> extends GraphCycleDetector<T> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger( DirectedGraphCycleDetector.class );
    
    public DirectedGraphCycleDetector(Graph<T> graph) {
        super(graph);
    }
    
    @Override
    public boolean isCycleFound() {
        
        int verticesCount = graph.getVerticesCount();
        if(verticesCount < 1 ) {
            return false;
        }
    
        Set<T> visitedNodes = new HashSet<>( verticesCount);
        
        // Do DFS
        for(T v : graph.getAllVertices()) {
            if(visitedNodes.contains(v)) { // if DFS has been done on this node, bypass
                continue;
            }
            
            // Do DFS from current vertex
            if(dfs(v, visitedNodes, new HashSet<>())) {
               return true;
            }
        }
        
        return false;
    }
    
    // Returns true if cycle is detected
    private boolean dfs(T current, Set<T> visitedNodes, HashSet<T> currStackVisited) {
        LOGGER.info( "Processing: c={} | currStackVisited: {} | visitedNodes: {}",
                     current, currStackVisited, visitedNodes );
        
        // First termination condition
        if(currStackVisited.contains( current )) {
            return true; // This vertex was already visited in current recursion, hence cycle found
        }
        
        // mark this node as visited
        visitedNodes.add( current );
        currStackVisited.add( current );
        
        // If the current vertex has no (further) connectivity, loop will exhaust and we return false;
        boolean cycleFound;
        for(T v : graph.getNeighbours(current)) {
            cycleFound = dfs(v, visitedNodes, currStackVisited);
            /* We need to remove the vertex when we backtrack from recursion. Else we can get false positives.
            *  Analyse this. The following graph has no cycle, but it can cause a false positive while backtracking
            *  at vertex 2 when it hits 6 again. To avoid this, we remove current node when backtracking.
            *
            *       +--> 5 --+
            *       |        |
            *       |        v
            *  1 -> 2        6
            *       |        ^
            *       |        |
            *       +--> 4 --+
            */
            currStackVisited.remove( v );
            if(cycleFound) {
                return true;
            }
        }
        
        return false;
    }
    
}
