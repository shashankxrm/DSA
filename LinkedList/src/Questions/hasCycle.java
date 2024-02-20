package Questions;

public class hasCycle {
    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
    public int CycleLength(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                // calculate length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }
    // Finding Starting point of a cycle
    public ListNode detectCycle(ListNode head) {
        ListNode fast=detect(head);
        if(fast==null)
            return null;
        ListNode slow=head;
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public ListNode detect(ListNode head){
        if(head==null || head.next==null)
            return null;
        ListNode fast=head, slow=head, x=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return fast;
        }
        return null;
    }
}

