package tree;

// LC 199 : Binary Tree Right Side View
// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
// you can see ordered from top to bottom.
// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

import java.util.*;
public class leftViewOfABT {
    public List<Integer> rightSideView(TreeNode root) { // O(n) O(n)
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(i == 0){
                    res.add(node.val);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                if(node.left != null){
                    q.add(node.left);
                }
            }
        }
        return res;
    }

    // O(1) space
    public List<Integer> rightSideView2(TreeNode root) { // O(n) O(1)
        List<Integer> res = new ArrayList<>();
        rightView(root, res, 0);
        return res;
    }

    private void rightView(TreeNode root, List<Integer> res, int level){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(root.val);
        }
        rightView(root.right, res, level + 1);
        rightView(root.left, res, level + 1);
    }
}
