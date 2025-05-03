package tree;

// LC 987 : Vertical Order Traversal of a Binary Tree
// Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
// For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and
// (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
// The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from
// the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column.
// In such a case, sort these nodes by their values.
// Return the vertical order traversal of the binary tree.
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[9],[3,15],[20],[7]]
// Explanation:
// Column -1: Only node 9 is in this column.
// Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
// Column 1: Only node 20 is in this column.
// Column 2: Only node 7 is in this column.
// Example 2:
// Input: root = [1,2,3,4,5,6,7]
// Output: [[4],[2],[1,5,6],[3],[7]]
// Explanation:
// Column -2: Only node 4 is in this column.
// Column -1: Only node 2 is in this column.
// Column 0: Nodes 1, 5, and 6 are in this column.
//           1 is at the top, so it comes first.
//           5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
// Column 1: Only node 3 is in this column.
// Column 2: Only node 7 is in this column.
import java.util.*;


public class verticalOrderTraversal {
    Map<Integer, ArrayList<int[]>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for(ArrayList<int[]> list: map.values()) {
            Collections.sort(list, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            ArrayList<Integer> current = new ArrayList<>();
            for(int[] num :  list) {
                current.add(num[1]);
            }
            result.add(current);
        }
        return result;

    }


    void dfs(TreeNode root, int index, int dept) {
        if(root == null) {
            return;
        }
        map.putIfAbsent(index, new ArrayList<>());
        map.get(index).add(new int[]{dept, root.val});
        dfs(root.left, index - 1, dept + 1);
        dfs(root.right, index + 1, dept + 1);
    }

    class Pair{
        TreeNode node;
        int x;
        int y;
        Pair(TreeNode node, int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
}
