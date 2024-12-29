package LL;

// LC 234 : Palindrome Linked List
// Given the head of a singly linked list, return true if it is a palindrome.
// Example 1:
// Input: head = [1,2,2,1]
// Output: true
// Example 2:
// Input: head = [1,2]
// Output: false

public class palindromeLL {
    public boolean isPalindrome(ListNode head) { // O(n) O(1)
        ListNode middle = middleNode(head);
        ListNode reversed = reverseListIteratively(middle);
        while(reversed != null){
            if(head.val != reversed.val){
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }
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
    public ListNode middleNode(ListNode head) { // O(n) O(1)
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
