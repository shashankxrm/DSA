package tree;

// LC 297 : Serialize and Deserialize Binary Tree
// Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
// or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization
// algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized
// to the original tree structure.
// Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow
// this format, so please be creative and come up with different approaches yourself.
// Example 1:
// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]
// Example 2:
// Input: root = []
// Output: []
// Example 3:
// Input: root = [1]
// Output: [1]
// Example 4:
// Input: root = [1,2]
// Output: [1,2]

public class serializeDeserializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) { // time : O(n), space : O(n)
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { // time : O(n), space : O(n)
        String[] arr = data.split(",");
        return deserialize(arr, new int[]{0});
    }

    private TreeNode deserialize(String[] arr, int[] index) {
        if (arr[index[0]].equals("#")) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index[0]++]));
        root.left = deserialize(arr, index);
        root.right = deserialize(arr, index);
        return root;
    }
}
