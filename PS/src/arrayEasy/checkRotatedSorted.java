package arrayEasy;
// LC 1752 : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
// Given an array nums, return true if the array was originally sorted in non-decreasing order,
// then rotated some number of positions (including zero). Otherwise, return false.
// There may be duplicates in the original array.
// Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length],
// where % is the modulo operation.


public class checkRotatedSorted {
        public boolean check(int[] nums) {
            int n = nums.length;
            boolean rotated = false;

            for (int i = 1; i < n; i++) {
                if (nums[i] < nums[i - 1]) {
                    if (rotated) {
                        return false; // Found descending order after rotation
                    } else {
                        rotated = true; // Mark as rotated
                    }
                }
            }

            // Check if the array is sorted after rotation
            if (rotated) {
                return nums[0] >= nums[n - 1]; // Check if the first element is greater than or equal to the last element
            }

            return true; // Array is already sorted in non-decreasing order
        }
    }



