package Interval;

// LC 253 : Meeting Rooms II
// Given an array of meeting time intervals where intervals[i] = [starti, endi],
// return the minimum number of conference rooms required.
// Example 1:
// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: 2
// Example 2:
// Input: intervals = [[7,10],[2,4]]
// Output: 1


public class meetingRooms2 {
    public int minMeetingRooms(int[][] intervals) { // time : O(nlogn), space : O(n)
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        java.util.Arrays.sort(start);
        java.util.Arrays.sort(end);
        int count = 0;
        int endIdx = 0;
        for(int i = 0; i < n; i++) {
            if(start[i] < end[endIdx]) {
                count++;
            } else {
                endIdx++;
            }
        }
        return count;
    }
    // O(n) time complexity approach
    public int minMeetingRooms2(int[][] intervals) { // time : O(n), space : O(n)
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        int max = -1;
        for(int i = 0; i < n; i++) {
            max = Math.max(end[i], max);
        }
        if(max == -1) return 0;
        int[] timeTable = new int[max + 1];
        for(int i = 0; i < n; i++) {
            int startTime = start[i];
            int endTime = end[i];
            timeTable[startTime] = Math.max(endTime + 1, timeTable[startTime]);
        }
        int currEnd = -1;
        int count = 0;
        for(int i = 0; i < timeTable.length; i++) {
            if(timeTable[i] != 0) {
                if(currEnd != -1) count++;
                currEnd = timeTable[i] - 1;
            }
            if(currEnd == i) currEnd = -1;
        }
        return count;
    }
}
