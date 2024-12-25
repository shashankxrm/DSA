package arrays;

// LC 325 : Maximum Size Subarray Sum Equals k
// Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k.
// If there isn't one, return 0 instead.
// Example 1:
// Input: nums = [1,-1,5,-2,3], k = 3
// Output: 4
// Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
// Example 2:
// Input: nums = [-2,-1,2,1], k = 1
// Output: 2
import java.util.*;

public class largestSubArrayWithKsum {
    public int maxSubArrayLen(int[] nums, int k) { // O(n) time and O(n) space
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = i + 1;
            } else if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        largestSubArrayWithKsum obj = new largestSubArrayWithKsum();
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(obj.maxSubArrayLen(nums, k));
    }
}
