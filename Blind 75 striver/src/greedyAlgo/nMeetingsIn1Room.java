package greedyAlgo;

// LC 252 : N meetings in one room
// There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of
// meeting i and F[i] is finish time of meeting i.
// What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held
// in the meeting room at a particular time?
// Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
// Example 1:
// Input: N = 6, S[] = {1,3,0,5,8,5}, F[] = {2,4,6,7,9,9}
// Output: 4
// Explanation: Four meetings can be held with given start and end timings.
// Example 2:
// Input: N = 8, S[] = {75250,50074,43659,8931,11273,27545,50879,77924}, F[] = {112960,114515,81825,93424,54316,35533,73383,160252}
// Output: 3
// Explanation: Only three meetings can be held with given start and end timings.

import java.util.Arrays;

public class nMeetingsIn1Room {
    public static int maxMeetings(int start[], int end[], int n) {
        int[][] meetings = new int[n][3];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
            meetings[i][2] = i + 1;
        }
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);
        int count = 1;
        int endtime = meetings[0][1];
        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > endtime) {
                count++;
                endtime = meetings[i][1];
            }
        }
        return count;
    }
}
