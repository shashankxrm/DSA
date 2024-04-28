package BSeasy;

// LC 34 : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
// target value.
// If target is not found in the array, return [-1, -1].

import java.util.Arrays;

public class firstNlastPosition {
        static int[] searchRange(int[] nums, int target) {
            int start = -1, end = -1;
            int left = 0, right = nums.length - 1;

            // First, find the start position of the target
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                if (nums[mid] == target) start = mid;
            }

            // Reset the search to find the end position
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                if (nums[mid] == target) end = mid;
            }

            if (start == -1) return new int[]{-1, -1}; // target not found
            return new int[]{start, end};
        }
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(Arrays.toString(searchRange(nums, 6)));
    }
    }


