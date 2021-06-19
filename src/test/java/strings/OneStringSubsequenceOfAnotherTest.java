package strings;

import org.junit.Assert;
import org.junit.Test;

public class OneStringSubsequenceOfAnotherTest {
    
    OneStringSubsequenceOfAnother subject = new OneStringSubsequenceOfAnother();
    
    @Test
    public void test_nullOrEmpty() {
        Assert.assertFalse(subject.isSubsequence( null, null ));
        Assert.assertFalse(subject.isSubsequence( "", null ));
        Assert.assertFalse(subject.isSubsequence( null, "" ));
        Assert.assertFalse(subject.isSubsequence( "a", "" ));
        Assert.assertFalse(subject.isSubsequence( "", "a" ));
        Assert.assertFalse(subject.isSubsequence( null, "a" ));
        Assert.assertFalse(subject.isSubsequence( "a", null ));
    }
    
    @Test
    public void test_1() {
        Assert.assertTrue(subject.isSubsequence( "abcde", "ce" ));
    }
    
    @Test
    public void test_2() {
        Assert.assertTrue(subject.isSubsequence( "abcde", "c" ));
    }
}
