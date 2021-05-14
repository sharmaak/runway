package dp;

import static org.junit.Assert.*;
import org.junit.Test;

public class CoinChangeProblemTest {
    
    private final int[] COINS_1 = {1,2,3};
    private final int N_1 = 4;
    private final int RESULT_1 = 4;
    
    private final int[] COINS_2 = {2, 5, 3, 6};
    private final int N_2 = 10;
    private final int RESULT_2 = 5;
    
    @Test
    public void test_1() {
        CoinChangeProblem subject = new CoinChangeProblem();
        assertEquals(RESULT_1, subject.coinChange( N_1, COINS_1 ));
    }
    
    @Test
    public void test_2() {
        CoinChangeProblem subject = new CoinChangeProblem();
        assertEquals(RESULT_2, subject.coinChange( N_2, COINS_2 ));
    }
    
}
