package Interval;

// LC 57 : Insert Interval
// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
// You may assume that the intervals were initially sorted according to their start times.
// Example 1:
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

import java.util.ArrayList;
import java.util.List;


public class insertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) { // time : O(n), space : O(n)
        List<int[]> result = new ArrayList<>();

        // Iterate through intervals and add non-overlapping intervals before newInterval
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add merged newInterval
        result.add(newInterval);

        // Add non-overlapping intervals after newInterval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }



    public int[][] insert2(int[][] intervals, int[] newInterval) { // time : O(n), space : O(n)
        int n = intervals.length;
        int[][] res = new int[n + 1][2];
        int index = 0;
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res[index++] = newInterval;
        while(i < n) {
            res[index++] = intervals[i++];
        }
        int[][] ans = new int[index][2];
        for(int j = 0; j < index; j++) {
            ans[j] = res[j];
        }
        return ans;
    }
}
