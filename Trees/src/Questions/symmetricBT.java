package Questions;
import java.util.LinkedList;
import java.util.Queue;

// LC 101 : https://leetcode.com/problems/symmetric-tree/
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


public class symmetricBT {
    public boolean isSymmetric(TreeNode root) {        // brute force
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null) {
                continue;
            }

            if(left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return true;
    }
    public boolean isSymmetric2(TreeNode root) {     // optimized recursive approach
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }
}
