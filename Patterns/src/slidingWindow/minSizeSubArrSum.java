package slidingWindow;

// LC209: Minimum Size Subarray Sum
// Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
// subarray of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
// Example 1: Input: nums = [2,3,1,2,4,3], target = 7 Output: 2 Explanation: The subarray [4,3] has the minimal length
// under the problem constraint.
public class minSizeSubArrSum {
    public int minSubArrayLen(int target, int[] nums) { // Time: O(n), Space: O(1)
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
