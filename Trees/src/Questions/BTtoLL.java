package Questions;

// LC 114 : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Given the root of a binary tree, flatten the tree into a "linked list":
// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.

// appproach : (brute force)
// normal pre order traversal. as you transverse, store it in a queue.
// in the end remove from queue and make a linked list.


public class BTtoLL {     // optimised approach
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while(temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left;
                current.left= null;
            }
            current = current.right;
        }

    }

}
