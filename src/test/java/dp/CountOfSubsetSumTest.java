package dp;

import static org.junit.Assert.*;
import org.junit.Test;

public class CountOfSubsetSumTest {
    
    @Test
    public void test_1() {
        CountOfSubsetSum subject = new CountOfSubsetSum();
        int count = subject.isSubsetExist( new int[]{2, 3, 5, 6, 8, 10}, 10 );
        assertEquals(3, count);
    }
    
    @Test
    public void test_2() {
        CountOfSubsetSum subject = new CountOfSubsetSum();
        int count = subject.isSubsetExist( new int[]{1, 2, 3, 4}, 5 );
        assertEquals(2, count);
    }
    
    @Test
    public void test_3() {
        CountOfSubsetSum subject = new CountOfSubsetSum();
        int count = subject.isSubsetExist( new int[]{1, 2, 3, 4, 5}, 10 );
        assertEquals(3, count);
    }
    
    @Test
    public void test_4() {
        new GenerateAllSubsets().generateAllSubsets( new int[]{1,2,2,4,5,6,7} );
    }
    
}
