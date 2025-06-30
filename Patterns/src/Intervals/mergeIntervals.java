package Intervals;

// LC56: Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of
// the non-overlapping intervals that cover all the intervals in the input.
// Example 1: Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
public class mergeIntervals {
    public int[][] merge(int[][] intervals) { // Time: O(n log n), Space: O(n)
        if (intervals.length == 0) return new int[0][0]; // If no intervals, return empty array
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // Sort by start time
        java.util.List<int[]> merged = new java.util.ArrayList<>();
        int[] currentInterval = intervals[0]; // Start with the first interval
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) { // If overlapping
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]); // Merge intervals
            } else {
                merged.add(currentInterval); // Add non-overlapping interval to result
                currentInterval = intervals[i]; // Move to next interval
            }
        }
        merged.add(currentInterval); // Add the last interval
        return merged.toArray(new int[merged.size()][]); // Convert list to array and return
    }
}
