package dp;

import org.junit.Assert;
import org.junit.Test;

public class CoinChangeMinTest {
    
    @Test
    public void test_1() {
        CoinChangeMin sub = new CoinChangeMin();
        Assert.assertEquals(2, sub.minCoinsRequiredForChange( new int[]{5,10,15}, 30 ));
    }
    
    @Test
    public void testCanNotMakeChange() {
        CoinChangeMin sub = new CoinChangeMin();
        Assert.assertEquals(-1, sub.minCoinsRequiredForChange( new int[]{5,10,15}, 101 ));
    }
    
    @Test
    public void test_2() {
        CoinChangeMin sub = new CoinChangeMin();
        Assert.assertEquals(2, sub.minCoinsRequiredForChange( new int[]{9, 6, 5, 1}, 11 ));
    }
    
    @Test
    public void test_3() {
        CoinChangeMin sub = new CoinChangeMin();
        Assert.assertEquals(3, sub.minCoinsRequiredForChange( new int[]{9, 6, 5, 1}, 13 ));
    }
}
