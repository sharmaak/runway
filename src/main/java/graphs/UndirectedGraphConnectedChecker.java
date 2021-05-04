package graphs;

import graphs.ds.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class UndirectedGraphConnectedChecker<T> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger( UndirectedGraphConnectedChecker.class );
    private Graph<T> graph;
    
    public UndirectedGraphConnectedChecker(Graph<T> graph) {
        this.graph = graph;
    }
    
    public boolean isGraphConnected() {

        if(graph.getVerticesCount() == 0) {
            return true; // By convention. Depends on how we treat it.
        }

        //1. Create a set to track visited nodes
        Set<T> visited = new HashSet<>(graph.getVerticesCount());
        //2. do DFS
        T vertex = graph.getAllVertices().iterator().next();
        dfs(vertex, null, visited);
        //3. If all vertices are visited, connected. Else not.
        return visited.size() == graph.getVerticesCount();
    }
    
    private void dfs(T current, T parent, Set<T> visited) {
        if(visited.contains( current )) {
            return;
        }
        visited.add( current );
        for(T v : graph.getNeighbours( current )) {
            if(v.equals( parent )) { continue; }
            dfs(v, current, visited);
        }
    }
}