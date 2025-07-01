package Intervals;

// LC729: Employee Free Time
// Given a list of employees' schedules where each schedule is a list of intervals representing the times they are busy,
// return a list of intervals representing the times when all employees are free.
// Each interval is represented as a list of two integers [start, end].
// Example 1: Input: schedules = [[[1,2],[5,6]],[[1,3]],[[4,10]]] Output: [[3,4]]
public class employeeFreeTime {
    public int[][] employeeFreeTime(int[][][] schedules) { // Time: O(n log n), Space: O(n)
        java.util.List<int[]> allIntervals = new java.util.ArrayList<>();
        for (int[][] schedule : schedules) {
            for (int[] interval : schedule) {
                allIntervals.add(interval);
            }
        }
        // Sort all intervals by start time
        allIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        java.util.List<int[]> freeTimes = new java.util.ArrayList<>();
        int end = allIntervals.get(0)[1]; // Initialize end with the first interval's end
        for (int i = 1; i < allIntervals.size(); i++) {
            int[] current = allIntervals.get(i);
            if (current[0] > end) { // If there is a gap
                freeTimes.add(new int[]{end, current[0]}); // Add free time interval
            }
            end = Math.max(end, current[1]); // Update end to the maximum end seen so far
        }
        return freeTimes.toArray(new int[freeTimes.size()][]); // Convert list to array and return
    }
}
