package stackNqueue;

// LC 239 : Sliding Window Maximum
// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array
// to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Return the max sliding window.
// Example 1:
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation:
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7


public class slidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) { // O(n) O(n)
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++){
            left[i] = (i % k == 0) ? nums[i] : Math.max(left[i - 1], nums[i]);
            int j = n - i - 1;
            right[j] = (j % k == 0) ? nums[j] : Math.max(right[j + 1], nums[j]);
        }
        int[] result = new int[n - k + 1];
        for(int i = 0; i < n - k + 1; i++){
            result[i] = Math.max(right[i], left[i + k - 1]);
        }
        return result;
    }
}
