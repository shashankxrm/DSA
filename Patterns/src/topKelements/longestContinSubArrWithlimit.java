package topKelements;

// LC1438: Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
// Given an array of integers nums and an integer limit, return the length of the longest continuous subarray such that
// the absolute difference between any two elements in this subarray is less than or equal to limit.
// Example 1: Input: nums = [8,2,4,7], limit = 4 Output: 2 Explanation: The longest subarray is [2,4] with absolute
// differences |2-4| = 2, |4-7| = 3, and |8-2| = 6 which is not within the limit.
public class longestContinSubArrWithlimit {
    public int longestSubarray(int[] nums, int limit) { // Time: O(n), Space: O(n)
        java.util.Deque<Integer> maxDeque = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> minDeque = new java.util.ArrayDeque<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
