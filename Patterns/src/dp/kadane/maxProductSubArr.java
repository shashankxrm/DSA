package dp.kadane;
// LC152: Maximum Product Subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number)
// which has the largest product and return its product.
// Example: Input: nums = [2,3,-2,4] Output: 6 (The maximum product subarray is [2,3])
public class maxProductSubArr {
    public int maxProduct(int[] nums) { // Time: O(n), Space: O(1)
        int maxProduct = nums[0]; // Initialize maxProduct with the first element
        int minProduct = nums[0]; // Initialize minProduct with the first element
        int result = nums[0]; // Initialize result with the first element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) { // If current number is negative, swap max and min
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(nums[i], maxProduct * nums[i]); // Update maxProduct
            minProduct = Math.min(nums[i], minProduct * nums[i]); // Update minProduct
            result = Math.max(result, maxProduct); // Update result if maxProduct is larger
        }
        return result; // Return the maximum product found
    }
}
