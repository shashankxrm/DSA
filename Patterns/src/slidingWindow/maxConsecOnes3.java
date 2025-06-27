package slidingWindow;

// LC1004: Max Consecutive Ones III
// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip
// at most k 0's. Example 1: Input: nums = [1,1,0,0,1,1,1,0], k = 2 Output: 6
public class maxConsecOnes3 {
    public int longestOnes(int[] nums, int k) { // Time: O(n), Space: O(1)
        int left = 0, maxLength = 0, zeroCount = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
