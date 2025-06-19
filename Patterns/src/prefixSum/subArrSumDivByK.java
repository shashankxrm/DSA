package prefixSum;

// LC974: Subarray Sums Divisible by K
// https://leetcode.com/problems/subarray-sums-divisible-by-k/
// Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
// Example 1:
// Input: A = [4,5,0,-2,-3,1], K = 5
// Output: 7

public class subArrSumDivByK {
    public int subarraysDivByK(int[] A, int K) { // Time: O(n), Space: O(n)
        int count = 0;
        int sum = 0;
        int[] prefixSumCount = new int[K];
        prefixSumCount[0] = 1; // To handle the case where a subarray starts from index 0

        for (int num : A) {
            sum += num;
            int mod = ((sum % K) + K) % K; // Ensure non-negative mod
            count += prefixSumCount[mod];
            prefixSumCount[mod]++;
        }

        return count;
    }
}
