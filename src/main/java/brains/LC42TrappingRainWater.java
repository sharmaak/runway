package brains;

/**
 * LeetCode 42 : 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it can trap after raining.
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this
 * case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class LC42TrappingRainWater {
    
    /**
     * Water will overfalow from boundaries. So we keep track of left and right boundaries using two pointers.
     * Whichever side we find the boundary to be lower, we start calculating water level from that side, becuase we
     * know that the water will level out at the lower level. Let us look at an example.
     *        ||
     *        ||   ||
     *  ||    ||   ||
     *  ||    ||   ||
     *  -------------
     *  0  1  2  3  4
     *  ^           ^
     *  In the diagram above, we start with pLeft at i=0 and pRight at i=4.
     *  Out of these two, we know water will level at the lower level, which is i=0.
     *  Now, consider this - for indices between i=0 and i=4, the height of wall can be
     *      a) greater than i=4, in which case water will level out at level of i=0
     *      b) equal to i=4, in which case water will level out at level of i=0
     *      c) less than i=0. Yes, i=0. In this case, water will still hold for limits of i=0 and i=4.
     *
     *  If we meet a scenario where leftMax > rightMax, then we start calculating water from right side, sweeping
     *  into the array. This is because, the water will level out on the lesser side.
     *
     *  It's hard to explain it in words, but if you think about it, it's obvious. Try it out on pen and paper :-)
     *
     * Runtime complexity: O(n)
     * Spacetime complexity : O(k) = O(1)
     */
    public int calcTrappedWater(int[] a) {
        if(a.length < 3) {
            /*
            we need at least 3 array elements to form a cavity to hold water.
                1 0 1
                #   #
                -----
                0 1 2
            */
            return 0;
        }
        
        int i=0;
        int j=a.length-1;
        int leftMax = a[i];
        int rightMax = a[j];
        int waterVolume = 0;
        while(i != j) {
            if(leftMax < rightMax) {
                if(a[i] > leftMax) {
                    leftMax = a[i];
                } else {
                    waterVolume += leftMax - a[i];
                    i++;
                }
            } else {
                if(a[j] > rightMax) {
                    rightMax = a[j];
                } else {
                    waterVolume += rightMax - a[j];
                    j--;
                }
            }
        }
        
        return waterVolume;
    }
}
