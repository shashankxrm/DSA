package recursion;

// LC 416 : Partition Equal Subset Sum
// Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets
// such that the sum of elements in both subsets is equal.
// Example 1:
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:
// Input: nums = [1,2,3,5]
// Output: false

public class partitionEqualSubSetSum {
    public boolean canPartition(int[] nums) { // O(n * target) O(target)
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: Subset with sum 0 is always achievable.

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

}
