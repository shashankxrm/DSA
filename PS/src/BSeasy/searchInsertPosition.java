package BSeasy;

// LC 35 : https://leetcode.com/problems/search-insert-position/
// Given a sorted array of distinct integers and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.


public class searchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length - 1, m = 0;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (nums[m] == target) {
                return m;  // Return the index immediately when the target is found
            } else if (target > nums[m]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        if(target < nums[m]){
            return m;
        } else {
            return m + 1;
        }
    }
}
