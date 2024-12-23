package arrays;
// LC 31 : Next Permutation
// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
// If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
// The replacement must be in place and use only constant extra memory.
// Example 1:
// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:
// Input: nums = [3,2,1]
// Output: [1,2,3]

import java.util.Arrays;
import java.util.Arrays;

public class nextPermutation {
    static int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Step 1: Find the first decreasing element from the end
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }

        // Step 2: If no such element is found, reverse the array (smallest permutation)
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        // Step 3: Find the smallest number larger than nums[index] to the right of index
        int smallestLargerIndex = n - 1;
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                smallestLargerIndex = i;
                break;
            }
        }

        // Step 4: Swap nums[index] with nums[smallestLargerIndex]
        swap(nums, index, smallestLargerIndex);

        // Step 5: Reverse the array after index to get the next permutation
        reverse(nums, index + 1, n - 1);

        return nums;
    }

    // Helper method to swap two elements
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse part of the array
    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] result = nextPermutation(nums);

        System.out.println("Next Permutation: " + Arrays.toString(result));
    }
}
