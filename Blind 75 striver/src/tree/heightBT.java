package tree;

// LC 104 : Maximum Depth of Binary Tree
// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3
// Example 2:
// Input: root = [1,null,2]
// Output: 2

public class heightBT {
    public int maxDepth(TreeNode root) { // time : O(n), space : O(n)
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int ans = Math.max(left, right) + 1;

        return ans;
    }
    // BFS approach
    public int maxDepth2(TreeNode root) { // time : O(n), space : O(n)
        if(root == null) return 0;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            count++;
        }
        return count;
    }
    // DFS approach
    public int maxDepth3(TreeNode root) { // time : O(n), space : O(n)
        if(root == null) return 0;
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        java.util.Stack<Integer> value = new java.util.Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return max;
    }
}
