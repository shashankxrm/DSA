package Questions;

// LC 116 : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
// Populating Next Right Pointers in Each Node
// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
// connect all the adjacent nodes at the same level in a binary tree

public class populateNextRightPointers {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;
            while(current != null) {
                current.left.next = current.right;
                if(current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
