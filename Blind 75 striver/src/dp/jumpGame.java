package dp;

// LC 55 : Jump Game
// Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
// Each element in the array represents your maximum jump length at that position.
// Determine if you are able to reach the last index.
// Example 1:
// Input: nums = [2,3,1,1,4]
// Output: true

public class jumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
    // more optimized solution
    static boolean canJump(int[] nums) {
        // If the array has only one element, you're already at the last index
        if (nums.length == 1) {
            return true;
        }

        // Initialize the target index as the last position in the array
        int target = nums.length - 1;

        // Traverse the array from the second-to-last element to the beginning
        for (int i = nums.length - 2; i >= 0; i--) {
            // Check if the current index can reach the target index
            if (i + nums[i] >= target) {
                target = i;  // Move the target to the current index
            }
        }

        // Check if we were able to move the target to the start of the array
        return target == 0;
    }
}
