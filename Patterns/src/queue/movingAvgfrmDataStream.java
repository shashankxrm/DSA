package queue;

// LC346: Moving Average from Data Stream
// Design a class to calculate the moving average of a stream of integers.
// The class should have a constructor that takes an integer size as an argument, which is the size of the moving window.
// The class should have a method `next(int val)` that takes an integer value as an argument and returns the moving
// average of the last `size` values.
// Example 1: Input: ["MovingAverage", "next", "next", "next"], [[3], [1], [10], [3]] Output: [null, 1.0, 5.5, 4.66667]
public class movingAvgfrmDataStream {
    private final int size;
    private final java.util.Queue<Integer> queue;
    private int sum;
    public movingAvgfrmDataStream(int size) { // Constructor to initialize the moving average calculator
        this.size = size;
        this.queue = new java.util.LinkedList<>();
        this.sum = 0;
    }
    public double next(int val) { // Method to add a new value and return the current moving average
        if (queue.size() == size) {
            sum -= queue.poll(); // Remove the oldest value if the queue is full
        }
        queue.offer(val); // Add the new value to the queue
        sum += val; // Update the sum with the new value
        return (double) sum / queue.size(); // Return the current moving average
    }
}
