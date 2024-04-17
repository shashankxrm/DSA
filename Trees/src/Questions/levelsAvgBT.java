package Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// LC 637 https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
public class levelsAvgBT {
    public List<Double> avgOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Double averageLevel = (double) 0;
            for (int i=0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                averageLevel += currentNode.val;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            averageLevel = averageLevel / levelSize;
            result.add(averageLevel);
        }
        return result;
    }
}
