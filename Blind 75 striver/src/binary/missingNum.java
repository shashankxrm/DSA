package binary;

// LC 268 : Missing Number
// Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.
// Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
// Example 1:
// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers,
// so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

public class missingNum {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    // solving using bit manipulation
    static int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n;
        for (int i = 0; i < n; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
