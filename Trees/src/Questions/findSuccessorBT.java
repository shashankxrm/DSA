package Questions;

import java.util.LinkedList;
import java.util.Queue;

// find the successor of a given node in a binary tree. The successor is the node that appears immediately after
// the given node in an inorder traversal.(Level order successor)
public class findSuccessorBT {
    public TreeNode findSuccessor(TreeNode root, int key){
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }
}
