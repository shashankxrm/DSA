package arrays;

// LC 485 : Max Consecutive Ones
// Given a binary array nums, return the maximum number of consecutive 1's in the array.
// Example 1:
// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
// Example 2:
// Input: nums = [1,0,1,1,0,1]
// Output: 2


public class maxConsecOnes {
    public int findMaxConsecutiveOnes(int[] nums) { // O(n) O(1)
        int max = 0;
        int count = 0;
        for(int num : nums){
            if(num == 1){
                count++;
                max = Math.max(max, count);
            }else{
                count = 0;
            }
        }
        return max;
    }
}
