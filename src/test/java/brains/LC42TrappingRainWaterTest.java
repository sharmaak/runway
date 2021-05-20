package brains;

import org.junit.Test;
import static org.junit.Assert.*;

public class LC42TrappingRainWaterTest {
    
    @Test
    public void test_0() {
        LC42TrappingRainWater subject = new LC42TrappingRainWater();
        assertEquals(0, subject.calcTrappedWater( new int[]{1,1} ));
    }
    
    @Test
    public void test_1() {
        LC42TrappingRainWater subject = new LC42TrappingRainWater();
        assertEquals(1, subject.calcTrappedWater( new int[]{1,0,1} ));
    }
    
    @Test
    public void test_2() {
        LC42TrappingRainWater subject = new LC42TrappingRainWater();
        assertEquals(1, subject.calcTrappedWater( new int[]{1,0,2} ));
    }
    
    @Test
    public void test_3() {
        LC42TrappingRainWater subject = new LC42TrappingRainWater();
        assertEquals(2, subject.calcTrappedWater( new int[]{2,0,2} ));
    }
    
    @Test
    public void test_4() {
        LC42TrappingRainWater subject = new LC42TrappingRainWater();
        assertEquals(5, subject.calcTrappedWater( new int[]{2,0,4,0,3} ));
    }
    
    @Test
    public void test_5() {
        LC42TrappingRainWater subject = new LC42TrappingRainWater();
        assertEquals(5, subject.calcTrappedWater( new int[]{2,0,4,0,3,2,1} ));
    }
    
    @Test
    public void test_6() {
        LC42TrappingRainWater subject = new LC42TrappingRainWater();
        assertEquals(6, subject.calcTrappedWater( new int[]{0,1,0,2,1,0,1,3,2,1,2,1} ));
    }
    
    @Test
    public void test_7() {
        LC42TrappingRainWater subject = new LC42TrappingRainWater();
        assertEquals(9, subject.calcTrappedWater( new int[]{4,2,0,3,2,5} ));
    }
    
    
}
