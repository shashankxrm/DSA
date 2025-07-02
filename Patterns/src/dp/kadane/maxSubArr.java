package dp.kadane;
// LC53: Maximum Subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number)
// which has the largest sum and return its sum.
// Example: Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6
public class maxSubArr {
    public int maxSubArray(int[] nums) { // Time: O(n), Space: O(1)
        int maxSum = nums[0]; // Initialize maxSum with the first element
        int currentSum = nums[0]; // Initialize currentSum with the first element
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); // Update currentSum
            maxSum = Math.max(maxSum, currentSum); // Update maxSum if currentSum is larger
        }
        return maxSum; // Return the maximum subarray sum
    }
}
