package graphs.cycle;

import graphs.ds.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class UndirectedGraphCycleDetector<T> extends GraphCycleDetector<T>{
    private static final Logger LOGGER = LoggerFactory.getLogger( UndirectedGraphCycleDetector.class );
    
    public UndirectedGraphCycleDetector(Graph<T> graph) {
        super(graph);
    }
    
    public boolean isCycleFound() {
        if(graph.getVerticesCount() == 0) {
            return false;
        }
        
        // 1. Initialize Set to keep track of visited vertices
        Set<T> visited = new HashSet<>(graph.getVerticesCount());
        
        // 2. Pick up one vertex
        
        // 3. Do dfs
        for(T v : graph.getAllVertices()) {
            if(visited.contains( v )) {
                continue;
            }
            if (dfs(v, null, visited, new HashSet<T>())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean dfs(T current, T parent, Set<T> visited, Set<T> stackVisited) {
        LOGGER.info( "Processing: c={} | p={} | currStackVisited: {} | visitedNodes: {}",
                     current, parent, stackVisited, visited );
        
        if(stackVisited.contains(current)) {
            return true; // Visiting a revisited node => cycle.
        }
        
        stackVisited.add( current );
        visited.add( current );
        
        boolean cycleFound;
        for(T v : graph.getNeighbours(current) ) {
            if(v == parent) { // do not go back where you cam from
                continue;
            }
    
            cycleFound = dfs(v, current, visited, stackVisited);
            stackVisited.remove( v );
            
            if(cycleFound) {
                return true;
            }
        }
        
        return false;
    }
    
}
