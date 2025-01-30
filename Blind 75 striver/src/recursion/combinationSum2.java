package recursion;

// LC 40 : Combination Sum II
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
// candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.
// Example 1:
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
// Example 2:
// Input: candidates = [2,5,2,1,2], target = 5
// Output: [[1,2,2],[5]]

import java.util.*;

public class combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) { // O(2^n) O(n)
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            current.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinationSum2 obj = new combinationSum2();
        System.out.println(obj.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)); // [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
        System.out.println(obj.combinationSum2(new int[]{2,5,2,1,2}, 5)); // [[1, 2, 2], [5]]
    }
}
