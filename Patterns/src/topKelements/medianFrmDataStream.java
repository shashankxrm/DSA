package topKelements;

// LC295: Find Median from Data Stream
// Design a data structure that supports the following two operations:
// 1. addNum(int num): Adds a integer number from the data stream to the data structure.
// 2. findMedian(): Returns the median of all elements so far.
// The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value,
// and the median is the average of the two middle values.
// Example 1: Input: ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"],
// [[[], [1], [2], [], [3], []]] Output: [null, null, null, 1.5, null, 2.0]
public class medianFrmDataStream {
    private final java.util.PriorityQueue<Integer> maxHeap; // Max-heap for the lower half of the numbers
    private final java.util.PriorityQueue<Integer> minHeap; // Min-heap for the upper half of the numbers
    public medianFrmDataStream() { // Constructor initializes the heaps
        maxHeap = new java.util.PriorityQueue<>((a, b) -> b - a); // Max-heap (largest at the top)
        minHeap = new java.util.PriorityQueue<>(); // Min-heap (smallest at the top)
    }
    public void addNum(int num) { // Method to add a number to the data structure
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num); // Add to max-heap if it's less than or equal to the largest in max-heap
        } else {
            minHeap.offer(num); // Otherwise, add to min-heap
        }
        // Balance the heaps: max-heap can have at most one more element than min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // Move the largest from max-heap to min-heap
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll()); // Move the smallest from min-heap to max-heap
        }
    }
    public double findMedian() { // Method to find the median of all added numbers
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek(); // If max-heap has more elements, return its top element
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // If both heaps are balanced, return average of tops
        }
    }
}
