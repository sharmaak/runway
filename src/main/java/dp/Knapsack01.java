package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * In the 0–1 Knapsack problem, we are given a set of items, each with a weight and a value, and we need to determine
 * the number of each item to include in a collection so that the total weight is less than or equal to a given limit
 * and the total value is as large as possible. There is single piece for each item, once used it is gne and can not
 * be reused.
 */
public class Knapsack01 {
    
    public int calculateMaxValue(int[] itemValues, int[] itemWeights, int knapsackCapacity) {
        if(itemValues == null || itemWeights == null) {
            throw new IllegalArgumentException("One of the input arrays is null");
        }
        if(knapsackCapacity <0) {
            throw new IllegalArgumentException("Knapsack capacity should be more than 0");
        }
        if(itemValues.length != itemWeights.length) {
            throw new IllegalArgumentException("array lengths do not match");
        }
        
        Map<String, Integer> memo = new HashMap<>();
        int maxValue = doCalc(itemValues, itemWeights, itemValues.length-1, knapsackCapacity, memo);
        //System.out.printf("memo: %s%n", memo);
        return maxValue;
    }
    
    private int doCalc(int[] v, int[] w, int maxIndex, int c,  Map<String, Integer> memo) {
        // Taking the 0-1 approach. We either choose an item or not.
        // terminal condition
        // maxIndex < 0 : because no more items left
        if(c==0 ||  maxIndex < 0) { // this item exhausted capacity, so include its value
            return 0;
        }
    
        // c<0 : Because this item won't fit in. So we send back negative ininity to ensure that
        //       the other values gets selected.
        if(c < 0 ) {
            return Integer.MIN_VALUE;
        }
        
        String key = c + "," + maxIndex;
    
        if( memo.containsKey(key) ) {
            return memo.get( key );
        }
        
        int include = v[maxIndex] + doCalc( v, w, maxIndex-1, c - w[maxIndex], memo );
        int exclude = doCalc( v, w, maxIndex - 1, c, memo );
        int maxValue = Integer.max(include, exclude);
        memo.put(key, maxValue);
        
        return maxValue;
    }
}
