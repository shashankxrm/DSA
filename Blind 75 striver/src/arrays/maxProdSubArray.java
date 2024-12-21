package arrays;

// LC 152 : Maximum Product Subarray
// Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
// It is guaranteed that the answer will fit in a 32-bit integer.
// A subarray is a contiguous subsequence of the array.
// Example 1:
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.


public class maxProdSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
    static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            if (current < 0) {
                // Swap max and min if the current number is negative
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Calculate the new max and min products including the current number
            maxProd = Math.max(current, maxProd * current);
            minProd = Math.min(current, minProd * current);

            // Update the result with the maximum product found so far
            result = Math.max(result, maxProd);
        }

        return result;
    }
    static int maxProduct1(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
