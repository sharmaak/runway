package dp;

/**
 * Given an array of integers and a sum, the task find count of subsets of the given array with a sum equal to a
 * given sum.
 *
 * https://www.techiedelight.com/subset-sum-problem/
 * https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
 */
public class CountOfSubsetSum {
    
    /**
     * For a given int[] `S`, checks if subsets exist which add up to given number `N`. Also prints the subsets.
     * @param s Array of integers
     * @param n The sum for which we need to detect subsets.
     * @return True, iff such a subset exists. False otherwise.
     * {1,2,3,4} N=5
     */
    public int isSubsetExist(int[] s, int n) {
        // This problem is similar to the subsets-minimum-difference problem (EqualSubsetSumPartition).
        // Generate all subsets and check sum. The question is how to we generate all subsets of a given set?
    
        int count = findAllSubsetsWithSumN(s, s.length-1, n);
        //System.out.println(count);
        
        return count;
    }
    
    private int findAllSubsetsWithSumN(int[] s, int maxIndex, int sum) {
        if( sum == 0 ) {
            return 1;
        }
        
        if( sum < 0 || maxIndex < 0 ) {
            return 0;
        }
        
        int include = findAllSubsetsWithSumN( s, maxIndex - 1, sum - s[maxIndex]);
        int exclude = findAllSubsetsWithSumN( s, maxIndex - 1, sum);
        return include + exclude;
    }
}
