package graphs;

import org.junit.Test;

import static org.junit.Assert.*;


public class LC323NumberOfConnectedComponentsInUndirectedGraphTest {
    
    @Test
    public void test_1() {
        LC323NumberOfConnectedComponentsInUndirectedGraph subject = new LC323NumberOfConnectedComponentsInUndirectedGraph();
        // 0 - 1 - 2
        int n = 3;
        int[][] edges = {
                {0,1}, {1,2}
        };
        assertEquals(1, subject.calculateConnectedComponents( n, edges ));
    }
    
    @Test
    public void test_2() {
        LC323NumberOfConnectedComponentsInUndirectedGraph subject = new LC323NumberOfConnectedComponentsInUndirectedGraph();
        // 0 - 1 - 2
        // +-------+
        int n = 3;
        int[][] edges = {
                {0,1}, {1,2}, {2,0}
        };
        assertEquals(1, subject.calculateConnectedComponents( n, edges ));
    }
    
    @Test
    public void test_3() {
        LC323NumberOfConnectedComponentsInUndirectedGraph subject = new LC323NumberOfConnectedComponentsInUndirectedGraph();
        // 0   1 - 2
        int n = 3;
        int[][] edges = {
                {1,2}
        };
        assertEquals(2, subject.calculateConnectedComponents( n, edges ));
    }
    
    @Test
    public void test_4() {
        LC323NumberOfConnectedComponentsInUndirectedGraph subject = new LC323NumberOfConnectedComponentsInUndirectedGraph();
        // 0   1 - 2 - 3
        //     +-------+
        int n = 4;
        int[][] edges = {
                {1,2}, {2,3}, {3,1}
        };
        assertEquals(2, subject.calculateConnectedComponents( n, edges ));
    }
    
    @Test
    public void test_5() {
        LC323NumberOfConnectedComponentsInUndirectedGraph subject = new LC323NumberOfConnectedComponentsInUndirectedGraph();
        // 0   1 - 2 - 3  4-5-6
        //     +-------+    +-7
        int n = 8;
        int[][] edges = {
                {1,2}, {2,3}, {3,1}, {4,5}, {5,6}, {5,7}
        };
        assertEquals(3, subject.calculateConnectedComponents( n, edges ));
    }
    
    @Test
    public void test_6() {
        LC323NumberOfConnectedComponentsInUndirectedGraph subject = new LC323NumberOfConnectedComponentsInUndirectedGraph();
        // 0   1 - 2 - 3 - 4-5-6
        //     +-------+    +-7
        int n = 8;
        int[][] edges = {
                {1,2}, {2,3}, {3,1}, {4,5}, {5,6}, {5,7}, {3,4}
        };
        assertEquals(2, subject.calculateConnectedComponents( n, edges ));
    }
    
    @Test
    public void test_7() {
        LC323NumberOfConnectedComponentsInUndirectedGraph subject = new LC323NumberOfConnectedComponentsInUndirectedGraph();
        // 0
        int n = 1;
        int[][] edges = {};
        assertEquals(1, subject.calculateConnectedComponents( n, edges ));
    }
    
    @Test
    public void test_8() {
        LC323NumberOfConnectedComponentsInUndirectedGraph subject = new LC323NumberOfConnectedComponentsInUndirectedGraph();
        // 0
        int n = 0;
        int[][] edges = {};
        assertEquals(0, subject.calculateConnectedComponents( n, edges ));
    }
}