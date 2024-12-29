package LL;

// LC 430 : Flatten a Multilevel Doubly Linked List
// You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
// which may or may not point to a separate doubly linked list. These child lists may have one or more children of their
// own, and so on, to produce a multilevel data structure, as shown in the example below.
// Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first
// level of the list.
// Example 1:
// Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
// Output: [1,2,3,7,8,11,12,9,10,4,5,6]
// Explanation:
// The multilevel linked list in the input is as follows:
// After flattening the multilevel linked list it becomes:
//
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node() {}
    public Node(int val) { this.val = val; }
    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}


public class flatteningOfLL {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node pseudoHead = new Node(0, null, head, null);
        flattenDFS(pseudoHead, head);
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }

    private Node flattenDFS(Node prev, Node curr) {
        if(curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;
        return flattenDFS(tail, tempNext);
    }
}
