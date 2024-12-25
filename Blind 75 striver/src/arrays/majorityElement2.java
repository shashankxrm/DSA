package arrays;

// LC 229 : Majority Element II
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
// Follow-up: Could you solve the problem in linear time and in O(1) space?
// Example 1:
// Input: nums = [3,2,3]
// Output: [3]
// Example 2:
// Input: nums = [2,2,1,1,1,1,2,2]
// Output: [1,2]


import java.util.ArrayList;
import java.util.List;

public class majorityElement2 {
    public List<Integer> majorityElement(int[] nums) { // O(n) time and O(1) space
        List<Integer> res = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 1;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,1,2,2};
        majorityElement2 obj = new majorityElement2();
        System.out.println(obj.majorityElement(nums));
    }
}
