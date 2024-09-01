package Interval;

// LC 252 : Meeting Rooms I
// Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
// Example 1:
// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: false
// Example 2:
// Input: intervals = [[7,10],[2,4]]
// Output: true

public class meetingRooms1 {
    public boolean canAttendMeetings(int[][] intervals) { // time : O(nlogn), space : O(1)
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
    // with better tme complexity
    public boolean canAttendMeetings2(int[][] intervals) { // time : O(n), space : O(1)
        int max = -1;
        for(int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][1], max);
        }
        if(max == -1) return true;
        int[] timeTable = new int[max + 1];
        for(int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            timeTable[startTime] = Math.max(endTime + 1, timeTable[startTime]);
        }
        int currEnd = -1;
        for(int i = 0; i < timeTable.length; i++) {
            if(timeTable[i] != 0) {
                if(currEnd != -1) return false;
                currEnd = timeTable[i] - 1;
            }
            if(currEnd == i) currEnd = -1;
        }
        return true;
    }
}
