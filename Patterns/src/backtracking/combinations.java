package backtracking;

import java.util.*;
// LC77: Combinations
// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// The solution set must not contain duplicate combinations.
// Example: Input: n = 4, k = 2 Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
public class combinations {
    public List<List<Integer>> combine(int n, int k) { // Time: O(n!/(k!(n-k)!)), Space: O(k)
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList)); // Add the current combination
            return;
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i); // Include the current number
            backtrack(result, tempList, n, k, i + 1); // Recur to build the next level
            tempList.remove(tempList.size() - 1); // Backtrack to explore other combinations
        }
    }
}
