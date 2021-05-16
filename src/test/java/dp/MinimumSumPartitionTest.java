package dp;

import org.junit.Assert;
import org.junit.Test;

public class MinimumSumPartitionTest {
    @Test
    public void test_1() {
        Assert.assertEquals(5, new MinimumSumPartition().findMinimumSumDifference(new int[]{10, 20, 15, 5, 25}));
    }
    
    @Test
    public void test_2() {
        Assert.assertEquals(0, new MinimumSumPartition().findMinimumSumDifference(new int[]{1,2,3,4}));
    }
}
