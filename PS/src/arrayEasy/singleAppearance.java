package arrayEasy;
// LC 136 : https://leetcode.com/problems/single-number/
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

import java.util.Arrays;

public class singleAppearance {
    public int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        sort(nums);
        int j = 0;
        for (int i = 1; i < nums.length; i = i + 2) {
            if (nums[j] != nums[i]){
                break;
            } else {
                j = j + 2;
            }
        }
        return nums[j];

    }
    static void sort(int[] nums){
        Arrays.sort(nums);
    }

    public int singleNumber2(int[] nums) {        // optimised
        int ans=nums[0];
        int i=0;
        while(i<nums.length-1){
            ans=ans^nums[i+1];
            i++;
        }
        return ans;
    }
}
