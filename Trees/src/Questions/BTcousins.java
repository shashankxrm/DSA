package Questions;

// LC 993 : https://leetcode.com/problems/cousins-in-binary-tree/
// Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
// return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
//Two nodes of a binary tree are cousins if they have the same depth with different parents.
//Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

public class BTcousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
                (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }

    TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }
        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    boolean isSibling (TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }

        return (
                (node.left == x && node.right == y) || (node.left == y && node.right == x)
                        || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }

    int level (TreeNode node, TreeNode x, int lev) {
        if(node == null) {
            return 0;
        }

        if(node == x) {
            return lev;
        }

        int l = level(node.left, x, lev+1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev+1);
    }
}
