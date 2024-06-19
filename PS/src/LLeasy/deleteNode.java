package LLeasy;

// LC 237: https://leetcode.com/problems/delete-node-in-a-linked-list/
// Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
// instead you will be given access to the node to be deleted directly.
// It is guaranteed that the node to be deleted is not a tail node in the list.
// Example:
// Input: head = [4,5,1,9], node = 5
// Output: [4,1,9]


public class deleteNode {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        ListNode curr = node;
        while(curr.next != null){
            curr.val = curr.next.val;
            curr = curr.next;
            if(curr.next == null){
                prev.next = null;
            } else {
                prev = prev.next;
            }
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
}
