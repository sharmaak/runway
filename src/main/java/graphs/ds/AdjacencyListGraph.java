package graphs.ds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * AdjacencyList implementation of graph, backed by java.util.HasMap. The type is the key in the backing hashMap,
 * hence it should implement equals() and hashCode() methods.
 * @param <T> The type of graph.
 *
 * @author Amit Kumar Sharma
 */
public class AdjacencyListGraph<T> implements Graph<T> {
    
    private final Map<T, List<T> > adjacencyList;
    private final boolean directional;
    
    /**
     * Constructor for undirected AdjacencyListGraph
     */
    public AdjacencyListGraph() {
        this(false);
    }
    
    /**
     * Constructor for AdjacencyListGraph
     * @param directional if true, creates a directed graph, else undirected graph.
     */
    public AdjacencyListGraph(boolean directional) {
        this.directional = directional;
        adjacencyList = new HashMap<>();
    }
    
    @Override
    public Graph<T> addVertex(T value) {
        adjacencyList.putIfAbsent( value, new LinkedList<>() );
        return this;
    }
    
    @Override
    public Graph<T> removeVertex(T value) {
        // remove vertex from key.
        this.adjacencyList.remove(value);
        // Now remove connectivity from rest of the nodes
        this.adjacencyList.values().forEach( e -> e.remove(value));
        
        return this;
    }
    
    @Override
    public Graph<T> addEdge(T val1, T val2) {
        
        // add vertices in safe manner
        addVertex( val1 );
        addVertex( val2 );
        safeAddEdge(val1, val2);
    
        if(!directional) {
            safeAddEdge(val2, val1);
        }
        
        return this;
    }
    
    /**
     * Adds an edge if it does not exist already.
     */
    protected void safeAddEdge(T v1, T v2) {
        // link vertices
        List<T> adjList = this.adjacencyList.get(v1);
        // If the edge does not exist, add it
        boolean edgeNotFound = true;
        for(T v : adjList) {
            if(v2.equals(v)) { // if edge already exists, do not add it.
                edgeNotFound = false;
                break;
            }
        }
        if(edgeNotFound) {
            adjList.add(v2);
        }
    }
    
    @Override
    public Graph<T> removeEdge(T val1, T val2) {
        this.adjacencyList.get(val1).remove(val2);
        if(!directional) {
            this.adjacencyList.get( val2 ).remove( val1 );
        }
        return this;
    }
    
    @Override
    public List<T> getNeighbours(T value) {
        return this.adjacencyList.get(value);
    }
    
    @Override
    public int getVerticesCount() {
        return adjacencyList.size();
    }
    
    @Override
    public Set<T> getAllVertices() {
        return adjacencyList.keySet();
    }
    
    @Override
    public String toString() {
        return "AdjacencyListGraph{" + "adjacencyList=" + adjacencyList + '}';
    }
}
