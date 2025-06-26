package prefixSum;

// LC560: Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
// Example 1: Input: nums = [1,1,1], k = 2 Output: 2 Example 2: Input: nums = [1,2,3], k = 3 Output: 2
import java.util.HashMap; import java.util.Map;
public class subArrSumEqualsK {
    public int subarraySum(int[] nums, int k) { // Time: O(n), Space: O(n)
        int count = 0; int sum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // To handle the case where a subarray starts from index 0
        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
