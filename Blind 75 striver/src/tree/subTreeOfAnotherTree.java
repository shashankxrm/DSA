package tree;

// LC 572 : Subtree of Another Tree
// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
// structure and node values of subRoot and false otherwise.
// A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
// The tree tree could also be considered as a subtree of itself.
// Example 1:
// Input: root = [3,4,5,1,2], subRoot = [4,1,2]
// Output: true
// Example 2:
// Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
// Output: false


public class subTreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) { // time : O(n x m), space : O(n)
        return subtreeHelper(root, subRoot, subRoot);

    }
    boolean subtreeHelper(TreeNode root, TreeNode subRoot, TreeNode currSub) {
        if (root == null && currSub == null)
            return true;
        if (root == null || currSub == null)
            return false;
        if (root.val == currSub.val && subtreeHelper(root.left, subRoot, currSub.left) &&
                subtreeHelper(root.right, subRoot, currSub.right)) {
            return true;
        }
        if (root.val == subRoot.val && subtreeHelper(root.left, subRoot, subRoot.left) &&
                subtreeHelper(root.right, subRoot, subRoot.right)) {
            return true;
        }
        return subtreeHelper(root.right, subRoot, subRoot) || subtreeHelper(root.left, subRoot, subRoot);
    }
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) { // time : O(n x m), space : O(n)
        if(root == null) return false;
        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) { // time : O(n), space : O(n)
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
