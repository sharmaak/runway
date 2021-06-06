package slidingwindow;

/**
 * Given an array of integers of size ‘n’.
 * Our aim is to calculate the maximum sum of ‘k’
 * consecutive elements in the array.
 *
 * Input  : arr[] = {100, 200, 300, 400}
 *          k = 2
 * Output : 700
 *
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
 *          k = 4
 * Output : 39
 * We get maximum sum by adding subarray {4, 2, 10, 23}
 * of size 4.
 *
 * Input  : arr[] = {2, 3}
 *          k = 3
 * Output : Invalid
 * There is no subarray of size 3 as size of whole
 * array is 2.
 */
public class MaxSumOfSubArray {
    
    public int calcMaxSum(int[] arr, int k) {
        int n = arr.length;
        if(n<k) {
            throw new IllegalArgumentException("k can not be greater than array length");
        }
        
        // Calc sum for first k elements
        int  sum=0;
        for(int i=0; i<k; i++) {
            sum = sum + arr[i];
        }
        int maxSum = sum;
        
        for(int i=k; i<n; i++) {
            // subtract the 'head' of previous window and add the 'tail' of current window
            sum = sum - arr[i-k] + arr[i];
            maxSum = Math.max( sum, maxSum );
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        MaxSumOfSubArray m = new MaxSumOfSubArray();
        int[] arr = new int[]{100, 200, 300, 400};
        System.out.println(m.calcMaxSum( arr,2 ));
    
        arr = new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(m.calcMaxSum( arr,4 ));
        
    }
    
}
