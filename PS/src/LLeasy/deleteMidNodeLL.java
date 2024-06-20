package LLeasy;

// LC 2095: https://leetcode.com/problems/delete-middle-of-linked-list/
// Given a singly linked list, delete the middle of the linked list. For example, if the given linked list is
// 1->2->3->4->5 then the linked list should be modified to 1->2->4->5

public class deleteMidNodeLL {
    public class ListNode {
        int val;
        Add2LLnums.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
    public ListNode deleteMiddle(ListNode head) {

    }
    static ListNode middle(ListNode head){
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null ){
            s = s.next;
            f = f.next.next;
        }
    }

}
