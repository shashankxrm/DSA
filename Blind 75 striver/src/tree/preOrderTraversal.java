package tree;

// LC 144 : Binary Tree Preorder Traversal
// Given the root of a binary tree, return the preorder traversal of its nodes' values.
// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]
// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [1,2,4,5,3,6,7,9,8]

import java.util.*;

public class preOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) { // O(n) O(n)
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
