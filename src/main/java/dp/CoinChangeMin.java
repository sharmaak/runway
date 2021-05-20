package dp;

import java.util.HashMap;

/**
 * A variation of `Coin Change` problem in `Unbounded Knapsack` classification.
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount
 * representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up
 * by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *  TODO : There is a non-recursive way of doing this with a one dimensional array. Refer to the medium blog below for
 *         explaination and techie-delight link for code guidance. For now, this is okay. #GetsTheJobDone.
 *
 * TODO: Look at the leetcode solution, learn it, save it : https://leetcode.com/problems/coin-change/solution/
 *
 * https://www.techiedelight.com/coin-change-making-problem-unlimited-supply-coins/
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * https://trykv.medium.com/how-to-solve-minimum-coin-change-f96a758ccade
 */
public class CoinChangeMin {
    
    public int minCoinsRequiredForChange(int[] coins, int value) {
        int count = findChangeRecursively(coins, coins.length-1, value, new HashMap<String, Integer>() );
        return count == Integer.MAX_VALUE ? -1 : count;
    }
    
    private int findChangeRecursively(int[] coins, int maxIndex, int value, HashMap<String, Integer> memo) {
        if(value == 0) {
            return 0;
        }
        
        if(value < 0 || maxIndex < 0) {
            return Integer.MAX_VALUE;
        }
        String key = value + "," + maxIndex;
        if(memo.containsKey( key )) {
            return memo.get( key );
        }
        
        int include = findChangeRecursively(coins, maxIndex, value - coins[maxIndex], memo);
        if(include != Integer.MAX_VALUE) {
            include ++;
        }
        int exclude = findChangeRecursively(coins, maxIndex-1, value, memo);
        
        int result =  Integer.min(include, exclude);
        memo.put( key, result );
        
        return result;
    }
}
