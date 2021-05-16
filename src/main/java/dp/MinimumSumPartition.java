package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference
 * between their sums is minimum.
 * If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and
 * the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 *
 * https://www.techiedelight.com/minimum-sum-partition-problem/
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 */
public class MinimumSumPartition {

    public int findMinimumSumDifference(int[] s) {
        return doPartition(s,s.length-1,0,0, new HashMap<>() );
    }
    
    private int doPartition(int[] s, int maxIndex, int s1, int s2, Map<String, Integer> memo) {
        if(maxIndex < 0) {
            return Math.abs(s1-s2);
        }
        // Construct a unique map key from dynamic elements of the input.
        // Note that we can uniquely identify the subproblem with `n` and `S1` only,
        // as `S2` is nothing but `S-S1`, where `S` is the sum of all elements
        String key = maxIndex + "|" + s1;
        if(memo.containsKey( key )) { return memo.get( key ); }
        
        // Include the current item in `S1` and recur for the remaining items `n-1`
        int s1Include  = doPartition( s, maxIndex-1, s1+s[maxIndex], s2, memo );
        // Include the current item in `S1` and recur for the remaining items `n-1`
        int s2Include  = doPartition( s, maxIndex-1, s1, s2+s[maxIndex], memo );
        // store the result
        memo.put( key, Math.min( s1Include, s2Include ) );
        
        return memo.get( key );
    }
}
