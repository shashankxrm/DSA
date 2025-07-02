package backtracking;
import java.util.*;
// LC78: Subsets
// Given a set of distinct integers, nums, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets.
// Example: Input: nums = [1,2,3] Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
public class subsets {
    public List<List<Integer>> subsets(int[] nums) { // Time: O(2^n * n), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add the current subset
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // Include the current number
            backtrack(result, tempList, nums, i + 1); // Recur with the next index
            tempList.remove(tempList.size() - 1); // Backtrack to explore other subsets
        }
    }

}
