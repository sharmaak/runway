package graphs.ds;

import java.util.List;
import java.util.Set;

public interface Graph<T> {
    
    Graph<T> addVertex(T value);
    
    Graph<T> removeVertex(T value);
    
    Graph<T> addEdge(T val1, T val2);
    
    Graph<T> removeEdge(T val1, T val2);
    
    List< T > getNeighbours(T value);
    
    int getVerticesCount();
    
    Set<T> getAllVertices();
}
