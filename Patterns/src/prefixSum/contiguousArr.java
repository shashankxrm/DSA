package prefixSum;
// LC525: Contiguous Array
// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
// A subarray is a contiguous non-empty sequence of elements within an array.
// ex1: Input: nums = [0,1] Output: 2Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
// ex2: Input: nums = [0,1,1,1,1,1,0,0,0,1,0,0,1,0,0,1,1,1,0] Output: 18
// Explanation: [0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0] is the longest contiguous subarray with an
// equal number of 0 and 1.
import java.util.*;
public class contiguousArr {
    public int findMaxLength(int[] nums) { // Time: O(n), Space: O(n)
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> prefixSumIndex = new HashMap<>();
        prefixSumIndex.put(0, -1); // To handle the case where a subarray starts from index 0
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1; // Treat 0 as -1 and 1 as +1
            if (prefixSumIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - prefixSumIndex.get(sum));
            } else {
                prefixSumIndex.put(sum, i);
            }
        }
        return maxLength;
    }
}
