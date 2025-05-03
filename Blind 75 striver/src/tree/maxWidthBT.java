package tree;

// LC 662 : Maximum Width of Binary Tree
// Given the root of a binary tree, return the maximum width of the given tree.
// The maximum width of a tree is the maximum width among all levels.
// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
// where the null nodes between the end-nodes are also counted into the length calculation.
// It is guaranteed that the answer will in the range of 32-bit signed integer.
// Example 1:
// Input: root = [1,3,2,5,3,null,9]
// Output: 4
// Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
// Example 2:
// Input: root = [1,3,null,5,3]
// Output: 2
// Explanation: The maximum width existing in the third level with the length 2 (5,3).

import java.util.LinkedList;

public class maxWidthBT {
    public int widthOfBinaryTree(TreeNode root) { // O(n) O(n)
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        q.add(root);
        index.add(0);
        int maxWidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int left = 0;
            int right = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                int idx = index.poll();
                if(i == 0){
                    left = idx;
                }
                if(i == size - 1){
                    right = idx;
                }
                if(node.left != null){
                    q.add(node.left);
                    index.add(2 * idx);
                }
                if(node.right != null){
                    q.add(node.right);
                    index.add(2 * idx + 1);
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }

    //constant space
    public int widthOfBinaryTree2(TreeNode root) { // O(n) O(1)
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxWidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int left = 0;
            int right = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(i == 0){
                    left = i;
                }
                if(i == size - 1){
                    right = i;
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            maxWidth = Math.max(maxWidth, right - left + 1);
        }
        return maxWidth;
    }
}
