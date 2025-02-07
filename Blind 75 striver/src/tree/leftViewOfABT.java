package tree;

// LC 199 : Binary Tree Right Side View
// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
// you can see ordered from top to bottom.
// Example 1:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

import java.util.*;

class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

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

    //left view
    public List<Integer> leftSideView(TreeNode root) { // O(n) O(n)
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
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return res;
    }

    // O(1) space
    public List<Integer> leftSideView2(TreeNode root) { // O(n) O(1)
        List<Integer> res = new ArrayList<>();
        leftView(root, res, 0);
        return res;
    }

    private void leftView(TreeNode root, List<Integer> res, int level){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(root.val);
        }
        leftView(root.left, res, level + 1);
        leftView(root.right, res, level + 1);
    }

    // top view
    public List<Integer> topView(TreeNode root) { // O(n) O(n)
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd;
            if(!map.containsKey(hd)){
                map.put(hd, node.val);
            }
            if(node.left != null){
                q.add(new Pair(node.left, hd - 1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, hd + 1));
            }
        }
        for(int key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    // O(1) space
    public List<Integer> topView2(TreeNode root) { // O(n) O(1)
        List<Integer> res = new ArrayList<>();
        topView(root, res, 0, 0);
        return res;
    }

    private void topView(TreeNode root, List<Integer> res, int hd, int level){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(root.val);
        }
        topView(root.left, res, hd - 1, level + 1);
        topView(root.right, res, hd + 1, level + 1);
    }

    // bottom view
    public List<Integer> bottomView(TreeNode root) { // O(n) O(n)
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd;
            map.put(hd, node.val);
            if(node.left != null){
                q.add(new Pair(node.left, hd - 1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, hd + 1));
            }
        }
        for(int key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    // O(1) space
    public List<Integer> bottomView2(TreeNode root) { // O(n) O(1)
        List<Integer> res = new ArrayList<>();
        bottomView(root, res, 0, 0);
        return res;
    }

    private void bottomView(TreeNode root, List<Integer> res, int hd, int level){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(root.val);
        }
        bottomView(root.right, res, hd + 1, level + 1);
        bottomView(root.left, res, hd - 1, level + 1);
    }



}
