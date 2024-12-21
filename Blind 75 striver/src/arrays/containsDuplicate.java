package arrays;

// LC 217 : Contains Duplicate
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
// Example 1:   Input: nums = [1,2,3,1]    Output: true

import java.util.HashSet;

public class containsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }

    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {         // array.sort() takes O(nlogn) time
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
