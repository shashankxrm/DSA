package prefixSum;
import java.util.*;

// LC560: Continuous Subarray Sum
// Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two
// whose elements sum up to a multiple of k, or false otherwise. A good subarray is a subarray that has at least two
// elements and the sum of its elements is a multiple of k. Example 1: Input: nums = [23,2,4,6,7], k = 6 Output: true
// Explanation: [23,2,4] is a continuous subarray of size 3 whose elements sum up to 29, which is a multiple of 6.
public class continousSubArrSum {
    public boolean checkSubarraySum(int[] nums, int k) { // Time: O(n), Space: O(n)
        if (nums.length < 2) return false; // Need at least two elements
        int sum = 0;
        Map<Integer, Integer> prefixSumMod = new HashMap<>();
        prefixSumMod.put(0, -1); // To handle the case where a subarray starts from index 0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k; // Handle case when k is 0
            if (prefixSumMod.containsKey(mod)) {
                if (i - prefixSumMod.get(mod) > 1) { // Check if the subarray size is at least 2
                    return true;
                }
            } else {
                prefixSumMod.put(mod, i); // Store the first occurrence of this mod value
            }
        }
        return false;
    }
}
