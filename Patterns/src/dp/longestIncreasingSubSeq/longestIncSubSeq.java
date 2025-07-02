package dp.longestIncreasingSubSeq;
// LC300: Longest Increasing Subsequence
// Given an integer array nums, return the length of the longest strictly increasing subsequence.
// A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the
// order of the remaining elements.
// For example, [3, 6, 2, 7] is a subsequence of [0, 3, 1, 6, 2, 2, 7].
// Example: Input: nums = [10,9,2,5,3,7,101,18] Output: 4 (The longest increasing subsequence is [2,3,7,101])
public class longestIncSubSeq {
    public int lengthOfLIS(int[] nums) { // Time: O(n^2), Space: O(n)
        if (nums.length == 0) return 0; // If the array is empty, return 0
        int n = nums.length;
        int[] dp = new int[n]; // DP array to store the lengths of increasing subsequences
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Each element is an increasing subsequence of length 1
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // If current element is greater than previous
                    dp[i] = Math.max(dp[i], dp[j] + 1); // Update the DP array
                }
            }
        }
        int maxLength = 0; // Find the maximum length from the DP array
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }
        return maxLength; // Return the length of the longest increasing subsequence
    }
}
