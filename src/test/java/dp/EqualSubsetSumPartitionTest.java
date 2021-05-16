package dp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualSubsetSumPartitionTest {
    
    @Test
    public void test_1() {
        EqualSubsetSumPartition subject = new EqualSubsetSumPartition();
        assertTrue(subject.isEqualSumSubsetExist(new int[]{1, 2, 3, 4}));
    }
    
    @Test
    public void test_2() {
        EqualSubsetSumPartition subject = new EqualSubsetSumPartition();
        assertTrue(subject.isEqualSumSubsetExist(new int[]{1, 1, 3, 4, 7}));
    }
    
    @Test
    public void test_3() {
        EqualSubsetSumPartition subject = new EqualSubsetSumPartition();
        assertFalse(subject.isEqualSumSubsetExist(new int[]{2, 3, 4, 6}));
    }
}
