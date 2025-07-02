package backtracking;

import java.util.*;
// LC90: Subsets II
// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets.
// Example: Input: nums = [1,2,2] Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
public class subSet2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) { // Time: O(2^n), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add the current subset
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates
            tempList.add(nums[i]); // Include the current number
            backtrack(result, tempList, nums, i + 1); // Recur with the next index
            tempList.remove(tempList.size() - 1); // Backtrack to explore other subsets
        }
    }
}
