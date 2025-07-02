package dp.zeroOneKnapsack;
// LC416: Partition Equal Subset Sum
// Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets
// such that the sum of elements in both subsets is equal.
// Example: Input: nums = [1,5,11,5] Output: true (The array can be partitioned into [1,5,5] and [11])
public class partitionEqualSubSetSum {
    public boolean canPartition(int[] nums) { // Time: O(n * sum), Space: O(sum)
        int sum = 0; // Initialize sum of the array
        for (int num : nums) {
            sum += num; // Calculate total sum
        }
        if (sum % 2 != 0) return false; // If sum is odd, cannot partition into two equal subsets
        int target = sum / 2; // Target sum for each subset
        boolean[] dp = new boolean[target + 1]; // DP array to track achievable sums
        dp[0] = true; // Zero sum is always achievable
        for (int num : nums) { // Iterate through each number in the array
            for (int j = target; j >= num; j--) { // Update DP array in reverse order
                dp[j] = dp[j] || dp[j - num]; // Check if current sum can be achieved
            }
        }
        return dp[target]; // Return whether target sum is achievable
    }
}
