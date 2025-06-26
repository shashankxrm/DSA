package prefixSum;

// LC862: Shortest Subarray with Sum at Least K.
// Given an array of integers nums and an integer k, return the length of the shortest non-empty subarray of nums with
// a sum at least k. If there is no non-empty subarray with sum at least k, return -1.
//ex1: Input: nums = [1,2,3,4,5], k = 11 Output: 3
// Explanation: The subarray [3,4,5] has a sum of 12 which is at least 11.
import java.util.*;
public class shortestSubArrSumAtleastK {
    public int shortestSubarray(int[] nums, int k) { // Time: O(n log n), Space: O(n)
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int minLength = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
