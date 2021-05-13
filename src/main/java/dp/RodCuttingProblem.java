package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the
 * rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by
 * cutting in two pieces of lengths 2 and 6)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 */
public class RodCuttingProblem {
    
    /**
     *
     * @param l Length of the rod
     * @param price Price index, where index i represents cost of piece of length i; price.length <= l
     * @return Maximum cost obtainable by cutting the rod into pieces of length.
     */
    public int maxValueWithoutMemo(int l, int[] price) {
        
        if(l == 0) { return 0; }
        
        int maxValue = 0;
        for(int i=0; i<l; i++) {
            // if we make a cut of length 'i' and calculate the max price for 'l-i'.
            maxValue = Math.max( maxValue, price[i] + maxValueWithoutMemo( l - (i + 1) , price ) );
        }
        
        return maxValue;
    }
    
    /**
     * Solution with memoization
     */
    public int maxValue(int l, int[] price) {
        int[] memo = new int[l+1];
        memo[0]=0;
        int result =  maxValueWithMemo( l, price, memo );
        System.out.printf( "memo=%s%n", Arrays.toString(memo));
        return result;
    }
    
   /*
    * We choose a pivot length 'i', and solve the problem for residual length (l-i). So let us say rod length is 8.
    * The first iteration, out pivot length becomes 1 and residual length becomes 7. When we call the recursive
    * function f(7), we are trying to find out what will be the maximum revenue for rod of length 7. This goes on
    * till rod length becomes 0. The cost for rod length '0', will always be '0' (as we can not charge our customers
    * for nothing!). This becomes the recusrion-termination condition.
    *
    * In the memoization array, each index 'j' represents rod of length 'i'. At index 'j' we store the solution for
    * rod of length 'j'.
    * */
    private int maxValueWithMemo(int l, int[] price, int[] memo) {
        if(l == 0) { return 0; }
        if(memo[l] != 0) return memo[l];
        
        int maxValue = 0;
        int j;
        for(int i=0; i<l; i++) {
            j=l-1-i;
            maxValue = Math.max( maxValue, price[i] + maxValueWithMemo( j , price, memo ) );
            memo[l] = maxValue;
        }
        return maxValue;
    }
    
    /**
     * A more useful and practical implementation which also tells which cuts to apply.
     */
    public Result findLengthsAndMaxCost(int l, int[] price) {
        Memo[] memo = new Memo[l+1]; // l+1 because we want to use 1 indexed array for readability.
        // Populate array with empty Memo objects
        for(int i=0; i<l+1; i++) { memo[i] = new Memo(); }
        // Put in value of length=0. Because this is the obvious base condition, always.
        memo[0].maxValue = 0;
        // Call in the recursive function to calculate maximum cost along with cut-lengths.
        findLengthsForMaxValue( l, price, memo );
        System.out.println(Arrays.toString(memo));
        
        // Out of the memo array, derive the cut-lengths as array.
        // Index i represents a rod of length 'i'. For this rod, the maximum revenue is stored in Memo.maxValue.
        // For rod of length 'i', the pivot-length at which maximum revenue comes is stored in Memo.length.
        // Example:
        //
        // length   | 1   2   3   4   5   6   7   8
        // --------------------------------------------
        // price    | 3   5   8   9  10  17  17  20
        //
        // memo array state at end :
        // [(l=-1,v=0), (l=1,v=3), (l=1,v=6), (l=1,v=9), (l=1,v=12), (l=1,v=15), (l=1,v=18), (l=1,v=21), (l=1, v=24)]
        //
        // From memo array it is easy to see that at index 'i', we know the pivot-length. So next we need to know that
        // for residual length (l-i), the pivot length is stored at index (l-i). So we keep hopping to 'residual-length'
        // nodes till we hit 0.
        int pendingLength = l;
        List<Integer> cuts = new LinkedList<>();
        while(pendingLength > 0) {
            cuts.add( memo[pendingLength].length );
            pendingLength = pendingLength - memo[pendingLength].length;
        }
        return new Result( memo[l].maxValue, cuts );
    }
    
    private int findLengthsForMaxValue(int l, int[] price, Memo[] memo) {
        if(l == 0) { return 0; }
        if(memo[l].maxValue != -1) return memo[l].maxValue;
        
        int currentValue;
        for(int i=0; i<l; i++) {
            currentValue = price[i] + findLengthsForMaxValue( l-1-i , price, memo);
            if(currentValue > memo[l].maxValue) {
                memo[l].maxValue = currentValue;
                memo[l].length = i+1;
            }
        }
        return memo[l].maxValue;
    }
}

class Memo {
    int length = -1;
    int maxValue = -1;
    
    public String toString() {
        return "(l="+length + ",v=" + maxValue + ")";
    }
}

class Result {
    int maxValue;
    List<Integer> cuts;
    
    public Result(int maxValue, List<Integer> cuts) {
        this.maxValue = maxValue;
        this.cuts = cuts;
    }
    
    public int getMaxValue() {
        return maxValue;
    }
    
    public List< Integer > getCuts() {
        return cuts;
    }
    
    @Override
    public String toString() {
        return "Result{" + "maxValue=" + maxValue + ", cuts=" + cuts + '}';
    }
}


