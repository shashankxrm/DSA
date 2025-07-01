package Intervals;

// LC1288: Remove Covered Intervals
// Given an array of intervals where intervals[i] = [starti, endi], return the number of intervals that are not covered
// by any other interval. An interval [a, b] is covered by an interval [c, d] if and only if c <= a and b <= d.
// Example 1: Input: intervals = [[1,4],[3,6],[2,8]] Output: 2 Explanation: The intervals [1,4] and [2,8] are not
// covered by any other interval, while [3,6] is covered by [2,8].
public class removeCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) { // Time: O(n log n), Space: O(1)
        java.util.Arrays.sort(intervals, (a, b) -> a[0] == b[0] ?
                Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int count = 0, end = 0;
        for (int[] interval : intervals) {
            if (interval[1] > end) { // If current interval is not covered
                count++;
                end = interval[1]; // Update end to current interval's end
            }
        }
        return count; // Return the count of non-covered intervals
    }
}
