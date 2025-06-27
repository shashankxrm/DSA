package prefixSum;
import java.util.HashMap;
import java.util.Map;

// LC1074: Number of Submatrices That Sum to Target
// Given a matrix and a target sum, return the number of submatrices that sum to the target. A submatrix x1, y1, x2, y2
// is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2. Two submatrices (x1, y1, x2, y2) and
// (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
// Example 1: Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 2 Output: 4
// Explanation: The four submatrices that sum to 2 are:
// 1. (0,0) to (0,1) 2. (0,1) to (0,2) 3. (1,0) to (1,2) 4. (2,1) to (2,2)

public class NumofSubMatsThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) { // Time: O(m * n^2), Space: O(m)
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        for (int left = 0; left < n; left++) {
            int[] rowSums = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    rowSums[i] += matrix[i][right];
                }
                count += subarraySum(rowSums, target);
            }
        }
        return count;
    }
    private int subarraySum(int[] nums, int target) {
        int count = 0, sum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // To handle the case where a subarray starts from index 0
        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - target)) {
                count += prefixSumCount.get(sum - target);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
