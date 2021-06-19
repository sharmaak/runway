package strings;

import org.junit.Assert;
import org.junit.Test;

public class LC792NumberOfMatchingSubsequencesTest {
    
    private LC792NumberOfMatchingSubsequences subject = new LC792NumberOfMatchingSubsequences();
    
    @Test
    public void test_1() {
        Assert.assertEquals(3,
                            subject.numMatchingSubseq( "abcde", new String[]{"a","bb","acd","ace"} ));
    }
    
    @Test
    public void test_2() {
        Assert.assertEquals(2,
                            subject.numMatchingSubseq( "dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"} ));
    }
    
    @Test
    public void test_3() {
        Assert.assertEquals(2,
                            subject.numMatchingSubseq( "qlhxagxdqh", new String[]{"qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"} ));
    }
}
