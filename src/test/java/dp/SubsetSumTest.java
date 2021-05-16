package dp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubsetSumTest {
    
    @Test
    public void test_1() {
        SubsetSum subject = new SubsetSum();
        assertTrue(subject.isSubsetForSumExist(new int[]{3, 34, 4, 12, 5, 2}, 9));
    }
    
    @Test
    public void test_2() {
        SubsetSum subject = new SubsetSum();
        assertFalse(subject.isSubsetForSumExist(new int[]{3, 34, 4, 12, 5, 2}, 30));
    }
    
    
    @Test
    public void test_3() {
        SubsetSum subject = new SubsetSum();
        assertTrue(subject.isSubsetForSumExist(new int[]{1, 2, 7, 1, 5}, 10));
    }
}
