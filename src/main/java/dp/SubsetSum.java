package dp;


/**
 * Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number ‘S’.
 */
public class SubsetSum {
    public boolean isSubsetForSumExist(int[] s, int n) {
        Boolean[][] memo = new Boolean[n+1][s.length]; // n+1 because n is an actual value we will be accessing.
        return doCheck(s, s.length-1, n, memo );
    }
    
    private boolean doCheck(int[] s, int maxIndex, int n, Boolean[][] memo) {
        // termination case
        if(n==0) { return true; }
        if(n<=0 || maxIndex < 0 ) { return false; }
        
        if(memo[n][maxIndex] != null) {
            return memo[n][maxIndex];
        }
        
        boolean include = doCheck( s, maxIndex - 1, n - s[maxIndex], memo );
        boolean exclude = doCheck( s, maxIndex - 1, n, memo );
        memo[n][maxIndex] = include || exclude;
        return memo[n][maxIndex];
    }
}
