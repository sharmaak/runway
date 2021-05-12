package dp;

/**
 *
 * Generates fibonacci numbers for give index. The index is 0 based, i.e., f(0)=0, f(1)=1, f(2)=1, f(3)=2, f(4)=3 so on.
 * Uses DP / memoization to ensure that the same results are not computed again and again.
 *
 * For theoretical details and stack-tree refer to:
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 */
public class FibonacciNumbers {
    /**
     * Function to generate n-th fibonacci number
     * @param n index of number to be generated
     * @return n-th fibonacci number
     */
    public long f(int n) {
        long[] cache = new long[n+1]; // n+1 because when we say f(4) we want array to store index [0,4]
        return calcFibonacci( n, cache);
    }
    
    private long calcFibonacci(int n, long[] cache) {
        if(n==0) { return 0; }
        if(n==1) { return 1; }
        if(cache[n] > 0 ) {
            return cache[n];
        }
        long result = calcFibonacci( n - 1, cache ) + calcFibonacci( n - 2, cache );
    
        if(cache[n] == 0) {
            cache[n] = result;
        }
    
        return result;
    }
}
