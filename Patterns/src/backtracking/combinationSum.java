package backtracking;
import java.util.*;
// LC39: Combination Sum
// Given an array of distinct integers candidates and a target integer target, return all unique combinations of
// candidates where the chosen numbers sum to target. // You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times.
// Example: Input: candidates = [2,3,6,7], target = 7 Output: [[2,2,3],[7]]
public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) { // Time: O(2^n), Space: O(n)
        List<List<Integer>> result = new ArrayList<>();
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
            tempList.add(candidates[i]); // Include the current candidate
            backtrack(result, tempList, candidates, remain - candidates[i], i); // Recur with the same index
            tempList.remove(tempList.size() - 1); // Backtrack to explore other combinations
        }
    }
}
