package LLeasy;

// GFG: https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=linked-list-insertion

public class inseertionStartnEnd {
    // Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x) {
        Node node = new Node(x);
        node.next = head; // Point the new node's next to the current head
        return node; // New node becomes the new head
    }

    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        Node node = new Node(x);
        if (head == null) {
            return node; // If the list is empty, new node becomes the head
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next; // Traverse to the end of the list
        }
        temp.next = node; // Append the new node at the end
        return head; // Head remains the same
    }
    class Node{
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }
}
