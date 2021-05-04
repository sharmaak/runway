package graphs.ds;

import junit.framework.TestCase;
import org.junit.Test;

public class AdjacencyListGraphTest extends TestCase {
    
    @Test
    public void testGetVerticesCountForUndirectedGraph() {
        Graph<Integer> ug = new AdjacencyListGraph<>();
        assertEquals( 0, ug.getVerticesCount() );
        
        ug.addVertex( 1 );
        assertEquals( 1, ug.getVerticesCount() );
        
        ug.addVertex( 2 );
        assertEquals( 2, ug.getVerticesCount() );
        
        ug.addEdge( 1,2 );
        assertEquals( 2, ug.getVerticesCount() );
        
        ug.addEdge( 1,3 );
        assertEquals( 3, ug.getVerticesCount() );
        
        ug.addEdge( 4,5 );
        assertEquals( 5, ug.getVerticesCount() );
    }
    
    @Test
    public void testGetVerticesCountForDirectedGraph() {
        Graph<Integer> ug = new AdjacencyListGraph<>();
        assertEquals( 0, ug.getVerticesCount() );
        
        ug.addVertex( 1 );
        assertEquals( 1, ug.getVerticesCount() );
        
        ug.addVertex( 2 );
        assertEquals( 2, ug.getVerticesCount() );
        
        ug.addEdge( 1,2 );
        assertEquals( 2, ug.getVerticesCount() );
        
        ug.addEdge( 1,3 );
        assertEquals( 3, ug.getVerticesCount() );
        
        ug.addEdge( 4,5 );
        assertEquals( 5, ug.getVerticesCount() );
    }
    
    @Test
    public void testPotatoUndirectedGraph() {
        System.out.println("Undirected Graph");
        // 1 -- 2 -- 3 -- 4
        Graph<Integer> graph = new AdjacencyListGraph<Integer>()
                                    .addEdge( 1,2 )
                                    .addEdge( 2,3 )
                                    .addEdge( 3,4 );
        System.out.println(graph.toString());

        /*
            1 -- 2
            |    |
            4 -- 3
        */
        graph.addEdge( 4,1 );
        System.out.println(graph.toString());
        
        /*
            1 -- 2
            | \  |
            4 -- 3
        */
        graph.addEdge( 1,3 );
        System.out.println(graph.toString());
    
        
        /*
            1 -- 2     5     6 -- 7
            | \  |                |
            4 -- 3                8
        */
        graph.addVertex( 5 );
        graph.addEdge( 6,7 ).addEdge( 7,8 );
        System.out.println(graph.toString());
    }
    
    @Test
    public void testPotatoDirectedGraph() {
        System.out.println("Directed Graph");
        // 1 -> 2 -> 3 -> 4
        Graph<Integer> graph = new AdjacencyListGraph<Integer>(true)
                .addEdge( 1,2 )
                .addEdge( 2,3 )
                .addEdge( 3,4 );
        System.out.println("1: " + graph.toString());

        /*
            1 -> 2
            ^    |
            |    v
            4 <- 3
        */
        graph.addEdge( 4,1 );
        System.out.println("2: " + graph.toString());
        
        /*
            1 -> 2
            ^ \  |
            |  > v
            4 <- 3
        */
        graph.addEdge( 1,3 );
        System.out.println("3: " + graph.toString());
    
        
        /*
            1 -> 2    5    6 -> 7
            ^ \  |              |
            |  > v              V
            4 <- 3              8
        */
        graph.addVertex( 5 );
        graph.addEdge( 6,7 ).addEdge( 7,8 );
        System.out.println("4: " + graph.toString());
        
        graph.removeEdge( 1,3 );
        System.out.println("Removed edge [1,3]>> "+ graph.toString());
    
        graph.removeVertex( 7 );
        System.out.println("Removed vertex 7>> "+ graph.toString());
        
    }
}