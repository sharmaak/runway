package graphs.cycle;

import graphs.ds.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GraphCycleDetector<T> {
    
    protected static final Logger LOGGER = LoggerFactory.getLogger( GraphCycleDetector.class );
    
    protected final Graph<T> graph;
    
    public GraphCycleDetector(Graph<T> graph) {
        this.graph = graph;
    }
    
    public abstract boolean isCycleFound();
    
}
