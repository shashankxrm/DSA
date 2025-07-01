package Intervals;

// LC452: Minimum Number of Arrows to Burst Balloons
// Given an array points where points[i] = [xi, yi] represents the x and y coordinates of a balloon, return the minimum number
// of arrows needed to burst all balloons. A balloon is burst by an arrow shot at x if x is between the start and end
// coordinates of the balloon (inclusive).
// Example 1: Input: points = [[10,16],[2,8],[1,6],[7,12]] Output: 2 Explanation: One way is to shoot an arrow at x = 6, which
// bursts balloons [2,8] and [1,6], and another arrow at x = 10 which bursts balloons [10,16].
public class minNumOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) { // Time: O(n log n), Space: O(1)
        if (points.length == 0) return 0; // If no balloons, return 0
        java.util.Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // Sort by end coordinate
        int arrows = 1; // Start with one arrow
        int end = points[0][1]; // End of the first balloon
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) { // If current balloon starts after the last arrow's end
                arrows++; // Need a new arrow
                end = points[i][1]; // Update end to current balloon's end
            }
        }
        return arrows; // Return total arrows needed
    }
}