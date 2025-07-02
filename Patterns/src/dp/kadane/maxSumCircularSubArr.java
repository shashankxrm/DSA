package dp.kadane;
// LC918: Maximum Sum Circular Subarray
// You are given an integer array nums. A subarray of nums is called circular if the end of the array is connected to the
// beginning of the array. For example, [1,2,3,4,5] is a circular subarray because the end connects to the start.
// The sum of a subarray is the sum of its elements. Return the maximum sum of a circular subarray.
// A circular subarray can be obtained by taking a non-circular subarray and adding the sum of the elements that are
// not included in the non-circular subarray.
// Example: Input: nums = [1,-2,3,-2] Output: 3 (The maximum circular subarray is [3])
public class maxSumCircularSubArr {
    public int maxSubarraySumCircular(int[] nums) { // Time: O(n), Space: O(1)
        int maxKadane = kadane(nums); // Maximum subarray sum using Kadane's algorithm
        int totalSum = 0; // Total sum of the array
        for (int num : nums) {
            totalSum += num; // Calculate total sum
            num = -num; // Negate the current number for the minimum subarray calculation
        }
        int minKadane = kadane(nums); // Minimum subarray sum using Kadane's algorithm
        int maxCircular = totalSum + minKadane; // Maximum circular subarray sum
        return maxKadane > maxCircular && maxKadane != 0 ? maxKadane : maxCircular; // Return the maximum of both sums
    }
    private int kadane(int[] nums) { // Helper method to find maximum subarray sum using Kadane's algorithm
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
