package Intervals;

// LC252: Meeting Rooms
// Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
// Example 1: Input: intervals = [[0,30],[5,10],[15,20]] Output: false
public class meetingRooms {
    public boolean canAttendMeetings(int[][] intervals) { // Time: O(n log n), Space: O(1)
        if (intervals.length == 0) return true; // If no intervals, return true
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // Sort by start time
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) { // If current meeting starts before the last one ends
                return false; // Cannot attend all meetings
            }
        }
        return true; // Can attend all meetings
    }
}
