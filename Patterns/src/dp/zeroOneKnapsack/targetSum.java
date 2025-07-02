package dp.zeroOneKnapsack;
// LC494: Target Sum
// You are given an integer array nums and an integer target.
// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums
// and then concatenate all the integers.
// For example, if nums = [2, 1] and target = 1, you can add a '-' before 2 and '+' before 1 to get "-2+1" which evaluates to -1.
// Return the number of different expressions that you can build, which evaluates to target.
// Example: Input: nums = [1,1,1,1,1], target = 3 Output: 5
public class targetSum {
    public int findTargetSumWays(int[] nums, int target) { // Time: O(n * sum), Space: O(sum)
        int sum = 0; // Initialize sum of the array
        for (int num : nums) {
            sum += num; // Calculate total sum
        }
        if (target > sum || (sum + target) % 2 != 0) return 0; // If target is impossible, return 0
        int subsetSum = (sum + target) / 2; // Calculate the subset sum needed
        int[] dp = new int[subsetSum + 1]; // DP array to track achievable sums
        dp[0] = 1; // Zero sum is always achievable
        for (int num : nums) { // Iterate through each number in the array
            for (int j = subsetSum; j >= num; j--) { // Update DP array in reverse order
                dp[j] += dp[j - num]; // Count ways to achieve current sum
            }
        }
        return dp[subsetSum]; // Return the number of ways to achieve the target sum
    }
}
