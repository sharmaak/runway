package graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC261GraphValidTreeTest {
    
    @Test
    public void test_1() {
        LC261GraphValidTree subject = new LC261GraphValidTree();
        // 0 - 1 - 2
        int n = 3;
        int[][] edges = {
                {0,1}, {1,2}
        };
        assertTrue(subject.isGraphValidTree( n, edges ));
    }
    
    @Test
    public void test_2() {
        LC261GraphValidTree subject = new LC261GraphValidTree();
        // 0 - 1 - 2
        // +-------+
        int n = 3;
        int[][] edges = {
                {0,1}, {1,2}, {2,0}
        };
        assertFalse(subject.isGraphValidTree( n, edges ));
    }
    
    @Test
    public void test_3() {
        LC261GraphValidTree subject = new LC261GraphValidTree();
        // 0   1 - 2
        int n = 3;
        int[][] edges = {
                {1,2}
        };
        assertFalse(subject.isGraphValidTree( n, edges ));
    }
    
    @Test
    public void test_4() {
        LC261GraphValidTree subject = new LC261GraphValidTree();
        // 0   1 - 2 - 3
        //     +-------+
        int n = 4;
        int[][] edges = {
                {1,2}, {2,3}, {3,1}
        };
        assertFalse(subject.isGraphValidTree( n, edges ));
    }
}