package Interval;

// LC 56 : Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
// array of the non-overlapping intervals that cover all the intervals in the input.
// Example 1:
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.

public class mergeIntervals {
    public int[][] merge2(int[][] intervals) { // time : O(nlogn), space : O(n)
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        java.util.List<int[]> result = new java.util.ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for(int[] interval : intervals) {
            if(interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    // O(n) time complexity approach
    public int[][] merge(int[][] intervals) { // too complex but O(n) complexity
        if (intervals.length == 1) {
            return intervals;
        }
        int max = -1;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }
        if (max == -1) {
            return new int[][] { intervals[0] };
        }
        int[] timeTable = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            timeTable[startTime] = Math.max(endTime + 1, timeTable[startTime]);
        }
        int resultSize = 0, currEnd = -1, currStart = -1;
        for (int i = 0; i < timeTable.length; i++) {
            if (timeTable[i] != 0) {
                if (currStart == -1) {
                    currStart = i;
                }
                currEnd = Math.max(timeTable[i] - 1, currEnd);
            }
            if (currEnd == i) {
                intervals[resultSize++] = new int[] { currStart, currEnd };
                currEnd = -1;
                currStart = -1;
            }
        }
        if (currStart != -1) {
            intervals[resultSize++] = new int[] { currStart, currEnd };
        }
        if (intervals.length == resultSize) {
            return intervals;
        }
        int[][] res = new int[resultSize][];
        for (int i = 0; i < resultSize; i++) {
            res[i] = intervals[i];
        }
        return res;
    }
}
