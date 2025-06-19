package prefixSum;

// LC303: Range Sum Query - Immutable
// https://leetcode.com/problems/range-sum-query-immutable/
// Given an integer array nums, handle multiple queries of the following type:
// Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
// Implement the NumArray class:
// NumArray(int[] nums) Initializes the object with the integer array nums.
// int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive
// (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
// Note:
// 1 <= nums.length <= 10^4
// -10^5 <= nums[i] <= 10^5
// 0 <= left <= right < nums.length
// At most 10^4 calls will be made to sumRange.
// ex1:
// Input: ["NumArray", "sumRange", "sumRange", "sumRange"]
// [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
// Output: [null, 1, -1, -3]

public class rangeSubQuery {
    private int[] prefixSum;

    public rangeSubQuery(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

}
