package slidingWindow;

// LC992: Subarrays with K Different Integers
// Given an array of integers nums and an integer k, return the number of good subarrays of nums.
// A good array is an array where the number of different integers in that array is exactly k.
// Example 1: Input: nums = [1,2,1,2,3], k = 2 Output: 7
// Explanation: The good subarrays are [1,2], [2,1], [1,2,1], [2,1,2], [1,2,3], [2,3], and [3].
public class SubArrWithKDiffIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) { // Time: O(n), Space: O(n)
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    private int atMostK(int[] nums, int k) {
        if (k < 0) return 0; // If k is negative, no subarray can satisfy it
        int count = 0; int left = 0;
        int[] freq = new int[nums.length + 1]; // Frequency array for counting distinct integers
        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]]++ == 0) k--; // New distinct integer found
            while (k < 0) {
                if (--freq[nums[left++]] == 0) k++; // Remove leftmost integer
            }
            count += right - left + 1; // Count all subarrays ending at 'right'
        }
        return count;
    }
}
