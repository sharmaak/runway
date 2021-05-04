package graphs;

import graphs.cycle.UndirectedGraphCycleDetector;
import graphs.ds.AdjacencyListGraph;
import graphs.ds.Graph;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class UndirectedGraphConnectedCheckerTest {
    
    @Test
    public void testIsGraphConnected_Empty() {
        Graph<Integer> g = new AdjacencyListGraph<>(false);
    }
    
    @Test
    public void testIsGraphConnected_OneVertex() {
        Graph<Integer> g = new AdjacencyListGraph<Integer>(false).addVertex( 1 );
        assertTrue( new UndirectedGraphConnectedChecker<Integer>( g ).isGraphConnected() );
    }
    
    @Test
    public void testIsGraphConnected_TwoVertexDisconnected() {
        // 1   2
        Graph<Integer> g = new AdjacencyListGraph<Integer>(false).addVertex( 1 ).addVertex( 2 );
        assertFalse( new UndirectedGraphConnectedChecker<Integer>( g ).isGraphConnected() );
    }
    
    @Test
    public void testIsGraphConnected_OneEdge() {
        // 1 -- 2
        Graph<Integer> g = new AdjacencyListGraph<Integer>(false).addEdge( 1,2 );
        assertTrue( new UndirectedGraphConnectedChecker<Integer>( g ).isGraphConnected() );
    }
    
    @Test
    public void testIsGraphConnected_Connected() {
        /*
         *       +--- 5 -- 6
         *       |
         *  1 -- 2
         *       |
         *       +--- 4
         */
        Graph< Integer > g = new AdjacencyListGraph< Integer >( false )
                                .addEdge( 1, 2 )
                                .addEdge( 2, 4 )
                                .addEdge( 2, 5 )
                                .addEdge( 5, 6 );
        assertTrue( new UndirectedGraphConnectedChecker<Integer>( g ).isGraphConnected() );
    }
    
    @Test
    public void testIsGraphConnected_Disconnected() {
        /*
         *       +--- 5 -- 6  99
         *       |
         *  1 -- 2
         *       |
         *       +--- 4
         */
        Graph< Integer > g = new AdjacencyListGraph< Integer >( false )
                .addEdge( 1, 2 )
                .addEdge( 2, 4 )
                .addEdge( 2, 5 )
                .addEdge( 5, 6 ).addVertex( 99 );
        assertFalse( new UndirectedGraphConnectedChecker<Integer>( g ).isGraphConnected() );
    }
    
    @Test
    public void testIsGraphConnected_Disconnected2() {
        /*
         *       +--- 5 -- 6    99 -- 22 -- 11
         *       |               |          |
         *  1 -- 2               +----------+
         *       |
         *       +--- 4
         */
        Graph< Integer > g = new AdjacencyListGraph< Integer >( false )
                .addEdge( 1, 2 )
                .addEdge( 2, 4 )
                .addEdge( 2, 5 )
                .addEdge( 5, 6 )
                .addEdge( 99,22 )
                .addEdge( 22,11 )
                .addEdge( 99,11 );
        assertFalse( new UndirectedGraphConnectedChecker<Integer>( g ).isGraphConnected() );
    }
}