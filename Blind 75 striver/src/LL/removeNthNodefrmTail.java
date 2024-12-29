package LL;

// LC 19 : Remove Nth Node From End of List
// Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Follow up: Could you do this in one pass?
// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

public class removeNthNodefrmTail {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i = 1; i <= n+1; i++){ // n+1 because we need to reach the node before the node to be deleted
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
