package topKelements;

// LC347: Top K Frequent Elements
// Given an integer array nums and an integer k, return the k most frequent elements.
// Example 1: Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
public class topKfreqEle {
    public int[] topKFrequent(int[] nums, int k) { // Time: O(n log k), Space: O(n).
        java.util.Map<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // Count frequency of each number
        }
        java.util.PriorityQueue<int[]> minHeap = new java.util.PriorityQueue<>(
            (a, b) -> a[1] - b[1] // Min-heap based on frequency
        );
        for (java.util.Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()}); // Add to heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Maintain size of heap to k
            }// Bucketsort can also be used for O(n) time complexity.
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0]; // Extract the top k frequent elements
        }
        return result; // Return the result array
    }
}
