package graphs.cycle;

import graphs.cycle.UndirectedGraphCycleDetector;
import graphs.ds.AdjacencyListGraph;
import graphs.ds.Graph;
import junit.framework.TestCase;

public class UndirectedGraphCycleDetectorTest extends TestCase {

    public void testIsCycleFoundInDirectedGraph_EmptyGraph() {
        Graph<Integer> g = new AdjacencyListGraph<>(false);
        assertFalse( new UndirectedGraphCycleDetector<>( g).isCycleFound() );
    }
    
    public void testIsCycleFoundInDirectedGraph_OneVertex() {
        Graph<Integer> g = new AdjacencyListGraph<Integer>(false).addVertex( 1 );
        assertFalse( new UndirectedGraphCycleDetector<>( g).isCycleFound() );
    }
    
    public void testIsCycleFoundInDirectedGraph_SelfCycle() {
        Graph<Integer> g = new AdjacencyListGraph<Integer>(false).addVertex( 1 ).addEdge( 1,1 );
        assertTrue( new UndirectedGraphCycleDetector<>( g).isCycleFound() );
    }
    
    public void testIsCycleFoundInDirectedGraph_SelfCycle2() {
        
        // 1 -- 2 -+
        //      |  |
        //      +--+
        Graph<Integer> g = new AdjacencyListGraph<Integer>(false)
                                            .addEdge( 1,2 )
                                            .addEdge( 2,2 );
        assertTrue( new UndirectedGraphCycleDetector<>( g).isCycleFound() );
    }
    
    public void testIsCycleFoundInDirectedGraph_NoCycle1() {
    
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
    
        assertFalse( new UndirectedGraphCycleDetector<>( g ).isCycleFound() );
    }
    
    public void testIsCycleFoundInDirectedGraph_NoCycle2() {
    
        /*
         *  1 -- 2 ------ 6
         *       |        |
         *       +--- 4 --+
         */
        Graph< Integer > g = new AdjacencyListGraph< Integer >( false )
                                    .addEdge( 1, 2 )
                                    .addEdge( 2, 4 )
                                    .addEdge( 4, 6 )
                                    .addEdge( 6, 2 );
        assertTrue( new UndirectedGraphCycleDetector<>( g ).isCycleFound() );
    }
    
    public void testIsCycleFoundInDirectedGraph_NoCycle3() {
        /*
         *  1 -- 2 -- 6    7 -- 8
         *       |
         *       |
         *       +--> 4
         */
        Graph< Integer > g = new AdjacencyListGraph< Integer >( false )
                                    .addEdge( 1, 2 )
                                    .addEdge( 2, 4 )
                                    .addEdge( 2, 6 )
                                    .addEdge( 7, 8 );
        assertFalse( new UndirectedGraphCycleDetector<>( g ).isCycleFound() );
    }
    
    public void testIsCycleFoundInDirectedGraph_NoCycle4() {
    
        /*
         *  a -- b -- d        k -- l -- m
         *       |             |         |
         *       +--- c        +---------+
         */
        Graph<String> g = new AdjacencyListGraph<String>( false )
                                    .addEdge( "a", "b" )
                                    .addEdge( "b", "c" )
                                    .addEdge( "c", "d")
                                    .addEdge( "b", "d" )
                                    .addEdge( "k", "l" )
                                    .addEdge( "l", "m" )
                                    .addEdge( "m", "k" );
        assertTrue( new UndirectedGraphCycleDetector<>( g).isCycleFound() );
    }
    
}