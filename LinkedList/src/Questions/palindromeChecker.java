package Questions;

public class palindromeChecker {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode head2 = reverseList(mid);
        ListNode rereverseHead = head2;
        // Compare both the halves
        while (head != null && head2 != null){
            if (head.val != head2.val){
                break;
            }
            head = head.next;
            head2 = head2.next;
        }
        reverseList(rereverseHead);
        return head == null || head2 == null;
    }
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        return prev;
    }
}
