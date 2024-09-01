package Interval;

// LC 435 : Non-overlapping Intervals
// Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the
// intervals non-overlapping.
// Example 1:
// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
// Example 2:
// Input: intervals = [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
// Example 3:
// Input: intervals = [[1,2],[2,3]]
// Output: 0
// Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


public class nonOverlappingIntervals {
    public int eraseOverlapIntervals2(int[][] intervals) { // time : O(nlogn), space : O(1)
        if(intervals.length == 0) return 0;
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }


    public int eraseOverlapIntervals(int[][] intervals) { // time : O(n), space : O(n)
        int max = intervals[0][1];
        int min = max;

        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }

        int shift = 1 - min;
        int maxIntervalRange = 2 + max - min;
        int[] rightEnds = new int[maxIntervalRange];

        for (int[] interval : intervals) {
            int left = interval[0] + shift;
            int right = interval[1] + shift;
            if (left > rightEnds[right]) {
                rightEnds[right] = left;
            }
        }

        int start = 1;
        int count = 1;

        for (int i = 2; i < maxIntervalRange; i++) {
            if (start <= rightEnds[i]) {
                count++;
                start = i;
            }
        }

        return intervals.length - count;
    }
}
