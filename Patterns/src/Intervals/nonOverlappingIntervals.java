package Intervals;

// LC435: Non-overlapping Intervals
// Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to
// remove to make the rest of the intervals non-overlapping.
// Example 1: Input: intervals = [[1,2],[2,3],[3,4],[1,3]] Output: 1 Explanation: [1,3] can be removed and the rest of the
// intervals are non-overlapping.
public class nonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) { // Time: O(n log n), Space: O(1)
        if (intervals.length == 0) return 0; // If no intervals, return 0
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); // Sort by end time
        int count = 0, end = intervals[0][1]; // Initialize count and end time of the first interval
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) { // If current interval starts before the last one ends
                count++; // Increment count of intervals to remove
            } else {
                end = intervals[i][1]; // Update end time to current interval's end
            }
        }
        return count; // Return the total count of removed intervals
    }

}
