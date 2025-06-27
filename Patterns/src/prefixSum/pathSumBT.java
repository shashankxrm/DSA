package prefixSum;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// LC437: Path Sum III
// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values
// along the path equals targetSum. The path does not need to start or end at the root or a leaf, but it must go
// downwards (i.e., traveling only from parent nodes to child nodes).
// Example 1: Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8 Output: 3
public class pathSumBT {
    public int pathSum(TreeNode root, int targetSum) { // Time: O(n), Space: O(n)
        HashMap<Long, Integer> hmap = new HashMap<>();
        hmap.put(0L, 1);
        return dfs(root, 0L, targetSum, hmap);
    }
    private int dfs(TreeNode root, long prefixSum, int targetSum, HashMap<Long, Integer> hmap) {
        if (root == null) return 0;
        prefixSum += root.val;
        int res = hmap.getOrDefault(prefixSum - targetSum, 0);
        hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);
        res += dfs(root.left, prefixSum, targetSum, hmap);
        res += dfs(root.right, prefixSum, targetSum, hmap);
        hmap.put(prefixSum, hmap.get(prefixSum) - 1);
        return res;
    }
}
