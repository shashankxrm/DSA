package tree;

// LC 94 : Binary Tree Inorder Traversal
// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,3,2]
// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [4,2,5,1,6,7,3,9,8]

import java.util.*;


public class inOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) { // O(n) O(n)
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
