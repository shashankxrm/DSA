package LLeasy;

// LC 206: https://leetcode.com/problems/reverse-linked-list/
// Reverse a singly linked list.
// Example:
// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL

public class ReverseLLRecursive {

        public ListNode reverseList(ListNode head) {
            return reverseListRecursively(head, null);
        }

        private ListNode reverseListRecursively(ListNode current, ListNode prev) {
            if (current == null) {
                return prev; // The previous node will be the new head when current is null
            }

            ListNode next = current.next; // Save the next node
            current.next = prev; // Reverse the current node's pointer
            return reverseListRecursively(next, current); // Recur for the next node
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
