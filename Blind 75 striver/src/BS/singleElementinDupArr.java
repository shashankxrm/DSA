package BS;

// LC 540 : Single Element in a Sorted Array
// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
// element which appears exactly once. Find this single element that appears only once. You must write an algorithm that
// runs in O(log n) time and uses O(1) extra space.
// Example 1:
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10

import java.util.*;

public class singleElementinDupArr {
    public int singleNonDuplicate(int[] nums) { // O(logn) O(1)
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(mid % 2 == 1){
                mid--;
            }
            if(nums[mid] == nums[mid + 1]){
                low = mid + 2;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}
