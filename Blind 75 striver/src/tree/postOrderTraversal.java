package tree;

// LC 145 : Binary Tree Postorder Traversal
// Given the root of a binary tree, return the postorder traversal of its nodes' values.
// Example 1:
// Input: root = [1,null,2,3]
// Output: [3,2,1]
// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [4,5,2,6,7,9,3,8,1]

import java.util.*;

public class postOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) { // O(n) O(n)
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
