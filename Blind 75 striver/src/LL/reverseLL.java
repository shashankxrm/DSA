package LL;

// LC 206 : Reverse Linked List
// Given the head of a singly linked list, reverse the list, and return the reversed list.
// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

public class reverseLL {
    public ListNode reverseListIteratively(ListNode head) { // O(n) O(1)
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next; // Save the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move the pointers one position ahead
            current = next;
        }
        return prev; // The previous node will be the new head
    }
    public ListNode reverseList(ListNode head) { // O(n) O(n)
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
