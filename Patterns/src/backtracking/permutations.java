package backtracking;

import java.util.*;
// LC46: Permutations
// Given an array of distinct integers, return all possible permutations.
// The solution set must not contain duplicate permutations.
// Example: Input: nums = [1,2,3] Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
public class permutations {
    public List<List<Integer>> permute(int[] nums) { // Time: O(n!), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add the current permutation
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip if already used
            used[i] = true; // Mark as used
            tempList.add(nums[i]); // Include the current number
            backtrack(result, tempList, nums, used); // Recur to build the next level
            tempList.remove(tempList.size() - 1); // Backtrack to explore other permutations
            used[i] = false; // Unmark for the next iteration
        }
    }
}
