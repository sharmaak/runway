package dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RodCuttingProblemTest {
    
    private static final int[] INPUT_1 = {1,5,8,9,10,17,17,20};
    private static final int INPUT_1_LENGTH = 8;
    private static final int INPUT_1_COST = 22;
    private static final List<Integer> INPUT_1_CUTS = Arrays.asList( 2,6 );
    
    private static final int[] INPUT_2 = {3,5,8,9,10,17,17,20};
    private static final int INPUT_2_LENGTH = 8;
    private static final int INPUT_2_COST = 24;
    private static final List<Integer> INPUT_2_CUTS = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1);
    
    @Test
    public void testMaxValueWithoutMemo_1() {
        assertEquals(INPUT_1_COST, new RodCuttingProblem().maxValueWithoutMemo( INPUT_1_LENGTH, INPUT_1 ) );
    }
    
    @Test
    public void testMaxValueWithoutMemo_2() {
        assertEquals(INPUT_2_COST, new RodCuttingProblem().maxValueWithoutMemo( INPUT_2_LENGTH, INPUT_2 ) );
    }
    
    @Test
    public void testMaxValue_1() {
        assertEquals(INPUT_1_COST, new RodCuttingProblem().maxValue( INPUT_1_LENGTH, INPUT_1 ) );
    }
    
    @Test
    public void testMaxValue_2() {
        assertEquals(INPUT_2_COST, new RodCuttingProblem().maxValue( INPUT_2_LENGTH, INPUT_2 ) );
    }
    
    @Test
    public void testFindLengthsAndMaxCost_1() {
        Result result = new RodCuttingProblem().findLengthsAndMaxCost( INPUT_1_LENGTH, INPUT_1 );
        assertEquals( INPUT_1_COST, result.getMaxValue() );
        assertTrue(INPUT_1_CUTS.size() == result.getCuts().size() &&
                   INPUT_1_CUTS.containsAll(result.getCuts()) &&
                   result.getCuts().containsAll(INPUT_1_CUTS));
    }
    
    @Test
    public void testFindLengthsAndMaxCost_2() {
        Result result = new RodCuttingProblem().findLengthsAndMaxCost( INPUT_2_LENGTH, INPUT_2 );
        assertEquals( INPUT_2_COST, result.getMaxValue() );
        assertTrue(INPUT_2_CUTS.size() == result.getCuts().size() &&
                   INPUT_2_CUTS.containsAll(result.getCuts()) &&
                   result.getCuts().containsAll(INPUT_2_CUTS));
    }
}
