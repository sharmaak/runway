package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of
 * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn't matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should
 * be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and
 * {5,5}. So the output should be 5.
 */
public class CoinChangeProblem {
    
    /**
     * Calculates the number of ways change can be generated for a given number 'n' and an infinite number of coins.
     *
     * @param n Number whose change has to be generated
     * @param coins Integer array containing coin denominations.
     * @return The number of ways in which change can be generated.
     */
    public int coinChange(int n, int[] coins) {
        return doChange(n, coins.length-1, coins, new HashMap<>() );
    }
    
    /*
     * n: the amount
     * i: array max index to include in solution
     * coins: array of coin denominations
     */
    private int doChange(int n, int i, int[] coins, Map<String, Integer> memo) {
        // termination condition
        if(n==0) { return 1; } // we found a solution
        if(n<0 || i<0) { return 0; } // can't make change or we ran out of denominations
        
        String key = n + "," + i;
        if( !memo.containsKey(key) ) {
            // we included a denomination
            int include = doChange( n - coins[i], i, coins, memo );
            // we exclude a denomination
            int exclude = doChange( n, i - 1, coins, memo );
            
            memo.put(key, include + exclude);
        }
        
        return memo.get( key );
    }
    
}
