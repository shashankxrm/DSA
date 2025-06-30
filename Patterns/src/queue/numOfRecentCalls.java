package queue;

// LC933: Number of Recent Calls
// Design a class to count the number of recent calls made. The class should have
// a method `ping(int t)` that takes an integer `t` representing the time of the call and returns the number of calls
// made in the last 3000 milliseconds.
// Example 1: Input: ["RecentCounter", "ping", "ping", "ping", "ping"], [[null], [1], [100], [3001], [3002]]
// Output: [null, 1, 2, 3, 3]
public class numOfRecentCalls { // Time: O(1) for each ping, Space: O(n) for storing timestamps
    private final java.util.Queue<Integer> queue; // Queue to store the timestamps of the calls
    public numOfRecentCalls() { // Constructor initializes the queue
        queue = new java.util.LinkedList<>();
    }

    public int ping(int t) { // Method to process a new call and return the count of recent calls
        queue.offer(t); // Add the current timestamp to the queue
        while (queue.peek() < t - 3000) { // Remove timestamps that are older than 3000 milliseconds from the current time
            queue.poll();
        }
        return queue.size(); // Return the number of recent calls within the last 3000 milliseconds
    }
}
