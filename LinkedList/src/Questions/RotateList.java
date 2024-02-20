package Questions;

import org.w3c.dom.ls.LSException;

public class RotateList {
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
    // analyse the rotateRight method and write me a rotateLeft method
    public ListNode rotateLeft(ListNode head, int k) {
        if (k < 1 || head == null || head.next == null){
            return head;
        }
        k = k % getLength(head);

        for (int i = 0; i < k; i++) {
            ListNode node = head;
            while (node.next != null){
                node = node.next;
            }
            ListNode last = node;
            ListNode current = head;
            last.next = current;
            head = current.next;
            current.next = null;
        }
        return head;
    }

    
}
