package arrays;

// LC 287 : Find the Duplicate Number
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.
// Example 1:
// Input: nums = [1,3,4,2,2]
// Output: 2
// Example 2:
// Input: nums = [3,1,3,4,2]
// Output: 3

import java.util.HashSet;
import java.util.Set;

public class findDuplicate {
    static int findDuplicate2(int[] nums) { // O(n) time and O(n) space and best solution
        boolean[] see = new boolean[nums.length];
        int i = 0;
        for(int num: nums){
            if(see[num]){
                return num;
            } else {
                see[num] = true;
            }
        }
        return -1;
    }
    public int findDuplicate(int[] nums) { // O(n) time and O(n) space
        if(nums.length == 0) return -1;
        Set<Integer> res = new HashSet<>();
        for(int num: nums){
            if(res.contains(num)){
                return num;
            } else {
                res.add(num);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};

    }
}
