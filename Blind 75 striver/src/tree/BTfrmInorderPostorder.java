package tree;

// LC 106 : Construct Binary Tree from Inorder and Postorder Traversal
// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder
// is the postorder traversal of the same tree, construct and return the binary tree.
// Example 1:
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]
// Example 2:
// Input: inorder = [-1], postorder = [-1]
// Output: [-1]
// Constraints:
// 1 <= inorder.length <= 3000

public class BTfrmInorderPostorder { // time : O(n), space : O(n)
    int postPointer=0;
    int inPointer=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postPointer=inorder.length;
        inPointer=inorder.length-1;
        return build(inorder,postorder,Integer.MAX_VALUE);
    }
    public TreeNode build(int[] inOrder,int[] postOrder,int last){
        if(postPointer<0 || inPointer<0){
            return null;
        }
        if(inOrder[inPointer]==last){
            inPointer-=1;
            return null;
        }
        postPointer-=1;
        TreeNode root=new TreeNode(postOrder[postPointer]);
        root.right=build(inOrder,postOrder,root.val);
        root.left=build(inOrder,postOrder,last);
        return root;
    }
}
