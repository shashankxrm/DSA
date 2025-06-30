package topKelements;

// LC703: Kth Largest Element in a Stream
// Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
// not the kth distinct element.
// Implement the KthLargest class:
// KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
// int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
// Example 1: Input: ["KthLargest", "add", "add", "add", "add", "add"], [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
// Output: [null, 4, 5, 5, 8, 8]
public class kthLargestinStream { // Time: O(log k) for each add operation, Space: O(k) for the min-heap
    private final int k; // The kth largest element to find
    private final java.util.PriorityQueue<Integer> minHeap; // Min-heap to store the k largest elements
    public kthLargestinStream(int k, int[] nums) { // Constructor initializes the min-heap and adds initial elements
        this.k = k;
        this.minHeap = new java.util.PriorityQueue<>();
        for (int num : nums) {
            add(num); // Add each number from the initial array to the heap
        }
    }
    public int add(int val) { // Method to add a new value and return the kth largest element
        if (minHeap.size() < k) {
            minHeap.offer(val); // Add value if we have less than k elements
        } else if (val > minHeap.peek()) {
            minHeap.poll(); // Remove the smallest element if the new value is larger
            minHeap.offer(val); // Add the new value
        }
        return minHeap.peek(); // Return the kth largest element, which is the root of the min-heap
    }
}
