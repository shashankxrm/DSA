package LL;

//  LC 25 : Reverse Nodes in k-Group
//  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//  k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not
//  a multiple of k then left-out nodes, in the end, should remain as it is.
//  You may not alter the values in the list's nodes, only nodes themselves may be changed.
//  Example 1:
//  Input: head = [1,2,3,4,5], k = 2
//  Output: [2,1,4,3,5]
//  Example 2:
//  Input: head = [1,2,3,4,5], k = 3
//  Output: [3,2,1,4,5]


public class reverseKorderLL {
    public ListNode reverseKGroup(ListNode head, int k) { // O(n) O(1)
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        curr = head;
        for(int i = 0; i < len/k; i++){
            for(int j = 1; j < k; j++){
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
