package dp;

import java.util.Arrays;

public class EqualSubsetSumPartition {
    
    public boolean isEqualSumSubsetExist(int[] s) {
        // A set can be partitioned into two equal subsets if
        //      sum(S) = sum(S1) + sum(S2)
        // Since sum(S1) = sum(S2) = n; let us say.
        //      sum(S) = n + n => sum(S) = 2n => n = sum(S)/2
        //   => sum(S1) = sum(S2) = sum(S)/2
        //   => sum(S) should be even number
        
        //1. Calculate sum of array elements
        int sum = Arrays.stream(s).sum();
        if(sum % 2 > 0) { return false;}
        
        int n = sum/2;
        return doCheck(s, s.length-1, n, new Boolean[s.length][n+1]);
    }
    
    private boolean doCheck(int[] s, int maxIndex, int n, Boolean[][] memo) {
        if(n==0) { return true; }
        if(n < 0 || maxIndex < 0 ) { return false; }
        
        if(memo[maxIndex][n] != null) { return memo[maxIndex][n]; }
        
        boolean include = doCheck( s, maxIndex-1, n-s[maxIndex], memo );
        boolean exclude = doCheck( s, maxIndex-1, n, memo );
        memo[maxIndex][n] = include || exclude;
        return memo[maxIndex][n];
    }
    
}
