package BSeasy;

// LC 540: https://leetcode.com/problems/single-element-in-a-sorted-array/
// You are given a sorted array consisting of only integers where every element appears exactly twice,
// except for one element which appears exactly once. Find this single element that appears only once.
// Follow up: Your solution should run in O(log n) time and O(1) space.

public class singleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (m % 2 == 1) m--;  // To make sure the mid is always even
            if (nums[m] == nums[m + 1]) {
                s = m + 2;
            } else {
                e = m;
            }
        }
        return nums[s];
    }
}
