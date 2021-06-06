package slidingwindow;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/max-value-of-equation/
 *
 * You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where
 * points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.
 *
 * Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.
 *
 * It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
 * Output: 4
 * Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 +
 * 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
 * No other pairs satisfy the condition, so we return the max of 4 and 1.
 * Example 2:
 *
 * Input: points = [[0,0],[3,0],[9,2]], k = 3
 * Output: 3
 * Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the
 * value of 0 + 0 + |0 - 3| = 3.
 *
 *
 * Constraints:
 *
 * 2 <= points.length <= 105
 * points[i].length == 2
 * -108 <= xi, yi <= 108
 * 0 <= k <= 2 * 108
 * xi < xj for all 1 <= i < j <= points.length
 * xi form a strictly increasing sequence.
 */
public class LC1499MaxValueOfEquation {
/*
    yi + yj + |xi - xj| ≡ (xi + yi) + (yj - xj)
    The value of (yj - xj) should be maximum for value to be max.
    
    Keep on iterating and adding all points to a max heap (priority queue)
    The point with maximum value of (yj - xj) stays on top.
    For this point we check if the current point's x is <= k units from the
    one on top of the heap.
    
    If the point of top of the heap is further than k, we eliminate that
    point from heap, as all subsequent points will be further away.
    
                         (x1+k)
                          |
    <---------- k ------->|
    +-------+----------+--+-------+-----------------+-------+---
    x1      x2         x3         x4                x5      x6
*/
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<Point> pq =
                new PriorityQueue<>((a,b) -> b.delta - a.delta);
        
        int[] current;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<points.length; i++) {
            current = points[i];
            
            // Remove all the points which are father away than k
            while(!pq.isEmpty() && current[0] - pq.peek().x > k) {
                pq.poll();
            }
            
            if(!pq.isEmpty()) {
                // Math.max(max, (xi + yi) + (yj - xj))
                maxValue = Math.max(maxValue, current[0] + current[1] + pq.peek().delta);
            }
            
            pq.offer(new Point(points[i][0], points[i][1]));
        }
        
        return maxValue;
    }
    
    class Point {
        int x;
        int y;
        int delta;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.delta = y-x;
        }
    }
}
