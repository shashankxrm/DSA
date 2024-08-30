package LL;

// LC 143 : Reorder List
// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.
// Example 1:
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]
// Example 2:
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]


public class reorderList {
    // This method is more efficient than the one we did before. Take a look at that.
    private ListNode temp;
    private boolean stop;
    public void reorderList(ListNode head) {
        temp = head;
        stop = false;
        reorder(head);
    }

    private void reorder (ListNode node) {
        if(node == null)
            return;
        //call recursively util we reach the end
        reorder(node.next);

        //if we have found the stop signal, we should not process anymore.
        if(stop)
            return;


        if(node == temp || node == temp.next) {
            //if we are in the middle of the list, we must stop and break the cycle
            node.next = null;
            stop = true;
        }
        else {
            //we merge the two node
            ListNode next = temp.next;
            temp.next = node;
            temp = temp.next;
            temp.next = next;
            temp = temp.next;
        }
    }
}
