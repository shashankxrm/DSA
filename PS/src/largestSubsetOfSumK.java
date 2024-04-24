
// Given an array of integers, find the length of the longest subarray with sum equals to K.
// Example 1:
// Input: [1, -1, 5, -2, 3], k = 3
// Output: 4


public class largestSubsetOfSumK {
    public static int longestSubarrayWithSumK(int []a, long k) {
        int left = 0, right = 0, maxLen = 0, n = a.length, sum = 0;

        while (right < n) {
            sum += a[right];

            while (sum > k) {
                sum -= a[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }
        return maxLen;
    }
}
