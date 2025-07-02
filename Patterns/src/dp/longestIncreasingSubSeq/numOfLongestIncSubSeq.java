package dp.longestIncreasingSubSeq;
// LC673: Number of Longest Increasing Subsequence
// Given an integer array nums, return the number of longest increasing subsequences.
// Notice that the sequence has to be strictly increasing.
// Example: Input: nums = [1,3,5,4,7] Output: 2 (The longest increasing subsequences are [1,3,4,7] and [1,3,5,7])
public class numOfLongestIncSubSeq {
    public int findNumberOfLIS(int[] nums) { // Time: O(n^2), Space: O(n)
        if (nums.length == 0) return 0; // If the array is empty, return 0
        int n = nums.length;
        int[] dp = new int[n]; // DP array to store the lengths of increasing subsequences
        int[] count = new int[n]; // Count array to store the number of increasing subsequences of that length
        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Each element is an increasing subsequence of length 1
            count[i] = 1; // Each element has one way to form a subsequence of length 1
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // If current element is greater than previous
                    if (dp[i] < dp[j] + 1) { // Found a longer increasing subsequence
                        dp[i] = dp[j] + 1; // Update the length
                        count[i] = count[j]; // Reset count to the count of the previous element
                    } else if (dp[i] == dp[j] + 1) { // Found another way to form the same length
                        count[i] += count[j]; // Add the count from the previous element
                    }
                }
            }
        }
        int maxLength = 0; // Find the maximum length from the DP array
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }
        int resultCount = 0; // Sum up counts of all longest increasing subsequences
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                resultCount += count[i];
            }
        }
        return resultCount; // Return the number of longest increasing subsequences
    }
}
