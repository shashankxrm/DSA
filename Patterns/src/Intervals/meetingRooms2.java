package Intervals;

// LC253: Meeting Rooms II
// Given an array of meeting time intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms
// required to hold all meetings.
// Example 1: Input: intervals = [[0,30],[5,10],[15,20]] Output: 2
public class meetingRooms2 {
    public int minMeetingRooms(int[][] intervals) { // Time: O(n log n), Space: O(n)
        if (intervals.length == 0) return 0; // If no intervals, return 0
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // Sort by start time
        java.util.PriorityQueue<Integer> endTimes = new java.util.PriorityQueue<>(); // Min-heap for end times
        for (int[] interval : intervals) {
            if (!endTimes.isEmpty() && interval[0] >= endTimes.peek()) {
                endTimes.poll(); // Reuse the room that has ended
            }
            endTimes.offer(interval[1]); // Add the current meeting's end time
        }
        return endTimes.size(); // The size of the heap is the number of rooms needed
    }
}
