package Questions;

// LC 105 : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree.
// Example 1:
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]

public class BTfrmPreOrderNinorder {
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex++]);

        int inIndex = 0;
        for(int i = start; i <= end; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        root.left = helper(preorder, inorder, start, inIndex - 1);
        root.right = helper(preorder, inorder, inIndex + 1, end);

        return root;
    }
}
