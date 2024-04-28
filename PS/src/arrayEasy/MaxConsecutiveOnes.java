package arrayEasy;
// LC 485 : https://leetcode.com/problems/max-consecutive-ones/
// Given a binary array nums, return the maximum number of consecutive 1's in the array.
// Example 1:
//Input: nums = [1,1,0,1,1,1]
//Output: 3



public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currOnes = 0;
        int maxOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                currOnes++;
                maxOnes = Math.max(currOnes, maxOnes);
            } else {
                currOnes = 0;
            }
        }
        return maxOnes;
    }

}
