package prefixSum;

// LC930: Binary Subarrays With Sum
// https://leetcode.com/problems/binary-subarrays-with-sum/
// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
// A subarray is a contiguous part of the array.
// Example 1:
// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are:
// [1,0,1], [0,1,0], [1,0,1], and [1,0,1].

public class binarySubArrWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) { // Time: O(n), Space: O(n)
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0; // If goal is negative, no subarray can satisfy it
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            goal -= nums[right];
            while (goal < 0) {
                goal += nums[left++];
            }
            count += right - left + 1; // Count all subarrays ending at 'right'
        }
        return count;
    }
}
