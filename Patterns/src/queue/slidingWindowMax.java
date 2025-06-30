package queue;

// LC239: Sliding Window Maximum
// Given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array
// to the very right. you can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Return the max sliding window.
// Example 1: Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7]
public class slidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) { // Time: O(n), Space: O(k)
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        java.util.Deque<Integer> deque = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) {
            // Remove elements not in the current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // Remove elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i); // Add current element index

            // Record the maximum for the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }
}
