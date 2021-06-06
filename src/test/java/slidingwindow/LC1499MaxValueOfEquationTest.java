package slidingwindow;

import static  org.junit.Assert.*;
import org.junit.Test;

public class LC1499MaxValueOfEquationTest {
    
    @Test
    public void test_1() {
        LC1499MaxValueOfEquation sub = new LC1499MaxValueOfEquation();
        int[][] input = {{0,0},{3,0},{9,2}};
        assertEquals(3, sub.findMaxValueOfEquation( input, 3 ));
    }
    
    @Test
    public void test_2() {
        LC1499MaxValueOfEquation sub = new LC1499MaxValueOfEquation();
        int[][] input = {{1,3},{2,0},{5,10},{6,-10}};
        assertEquals(4, sub.findMaxValueOfEquation( input, 1 ));
    }
    
    @Test
    public void test_3() {
        LC1499MaxValueOfEquation sub = new LC1499MaxValueOfEquation();
        int[][] input = {{-18,-5},{-15,11},{-14,9},{-12,-10},{-11,5},{-6,-11},{-3,13},{4,-13},{5,-7},{9,16},{10,2},
                         {11,14},{13,6},{19,-4}};
        assertEquals(32, sub.findMaxValueOfEquation( input, 7 ));
    }
}
