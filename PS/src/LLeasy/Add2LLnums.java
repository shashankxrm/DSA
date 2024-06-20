package LLeasy;

// LC 2: https://leetcode.com/problems/add-two-numbers/
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
// and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Example:
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.

public class Add2LLnums {
    public ListNode addTwoNumbersNOTWORKINGFORALL(ListNode l1, ListNode l2) {
        int num1 = num(l1);
        int num2 = num(l2);
        int sum = num1 + num2;

        ListNode head = new ListNode(sum % 10);
        ListNode temp = head;
        sum = sum / 10;

        while (sum > 0){
            int rem = sum % 10;
            ListNode node = new ListNode(rem);
            temp.next = node;
            temp = temp.next;
            sum = sum/10;
        }
        return head;

    }
    static int num(ListNode l){
        int power = 0;
        int sum = 0;
        ListNode temp = l;
        while (temp != null){
            sum = (int) (sum + temp.val * Math.pow(10, power));
            temp = temp.next;
            power++;
        }
        return sum;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
    }
}
