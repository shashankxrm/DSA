package Intervals;

// LC57: Insert Interval
// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary) and return the
// new set of non-overlapping intervals.
// Example 1: Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
public class insertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) { // Time: O(n), Space: O(n)
        java.util.List<int[]> merged = new java.util.ArrayList<>();
        int i = 0, n = intervals.length;
        // Add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i++]);
        }
        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval); // Add the merged interval
        // Add remaining intervals
        while (i < n) {
            merged.add(intervals[i++]);
        }
        return merged.toArray(new int[merged.size()][]); // Convert list to array and return
    }
}
