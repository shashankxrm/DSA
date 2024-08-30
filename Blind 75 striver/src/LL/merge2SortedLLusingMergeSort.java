package LL;

// LC 21 : Merge Two Sorted Lists
// Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes
// of the first two lists.
// Example 1:
// Input: l1 = [1,2,4], l2 = [1,3,4]
// Output: [1,1,2,3,4,4]


public class merge2SortedLLusingMergeSort {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //This node will act as the dummy head of the merged list
        ListNode ansNode = new ListNode();
        //Create a reference variable tail and set it to the ansNode. The tail will be used to traverse and build the merged list.
        ListNode tail = ansNode;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return ansNode.next;
    }
}
