package LL;

// LC 61 : Rotate List
// Given the head of a linked list, rotate the list to the right by k places.
// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]
// Constraints:
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109


public class rotateKtimes {
    public ListNode rotateRight(ListNode head, int k) {
        if (k < 1 || head == null || head.next == null){
            return head;
        }
        k = k % getLength(head);
        for (int i = 0; i < k; i++) {
            ListNode node = head;
            while (node.next.next != null){
                node = node.next;
            }
            ListNode prev = node;
            ListNode current = prev.next;
            current.next = head;
            prev.next = null;
            head = current;
        }
        return head;
    }
    public int getLength(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
