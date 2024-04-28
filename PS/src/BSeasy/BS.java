package BSeasy;

// LC 704: https://leetcode.com/problems/binary-search/
// Given an array of integers nums which is sorted in non-decreasing order, and an integer target,
// write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

public class BS {
    static int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) {
                return m;  // Return the index immediately when the target is found
            } else if (target > nums[m]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;  // Return -1 if the target is not found
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 9));
    }

}
