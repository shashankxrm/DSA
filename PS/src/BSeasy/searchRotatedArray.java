package BSeasy;

// LC 33 : https://leetcode.com/problems/search-in-rotated-sorted-array/
// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
// such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
// (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.


public class searchRotatedArray {
    static int search(int[] nums, int target) {
        int first = BS(nums, target, 0, pivot(nums) - 1);
        int second = BS(nums, target, pivot(nums), nums.length -1);
        return Math.max(first, second);
    }
    static int BS(int[] nums, int target, int s, int e) {
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
    static int pivot(int[] nums){
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (nums[m] > nums[e]) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums = {4 ,5, 6, 0, 1, 2, 3};
        System.out.println(search(nums, 7));
    }




}
