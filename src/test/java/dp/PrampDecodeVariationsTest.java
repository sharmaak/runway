package dp;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrampDecodeVariationsTest {
    
    @Test
    public void test_0() {
        assertEquals( 2, new PrampDecodeVariations().decodeVariations( "12" ) );
    }
    
    @Test
    public void test_1() {
        assertEquals( 3, new PrampDecodeVariations().decodeVariations( "1262" ) );
    }
    
    @Test
    public void test_2() {
        assertEquals( 144, new PrampDecodeVariations().decodeVariations( "11122222121" ) );
    }
    
    @Test
    public void test_3() {
        assertEquals( 0, new PrampDecodeVariations().decodeVariations( "738270" ) );
    }
}
