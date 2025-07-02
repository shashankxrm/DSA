package backtracking;

import java.util.*;
// LC40: Combination Sum II
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
// in candidates where the chosen numbers sum to target. Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.
// Example: Input: candidates = [10,1,2,7,6,1,5], target = 8
public class combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) { // Time: O(2^n), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return; // Exceeded the target sum
        if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue; // Skip duplicates
            tempList.add(candidates[i]); // Include the current candidate
            backtrack(result, tempList, candidates, remain - candidates[i], i + 1); // Recur with the next index
            tempList.remove(tempList.size() - 1); // Backtrack to explore other combinations
        }
    }
}
