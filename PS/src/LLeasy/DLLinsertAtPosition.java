package LLeasy;

// GFG: https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=insert-a-node-in-doubly-linked-list
// Given a doubly-linked list and a position. The task is to add a new node with the given data at the specified position in the doubly linked list.


public class DLLinsertAtPosition {
    void addNode(Node head_ref, int pos, int data)
    {
        Node temp = head_ref;

        // Traverse to the node at position `pos`
        for (int i = 0; i < pos; i++) {
            // If temp is null before reaching the desired position, break
            if (temp == null) {
                return; // Position is out of bounds
            }
            temp = temp.next;
        }

        Node node = new Node(data);

        if (temp == null) {
            // The list was shorter than the position given
            return;
        }

        Node next = temp.next;

        // Inserting the new node
        temp.next = node;
        node.prev = temp;

        if (next != null) {
            node.next = next;
            next.prev = node;
        }
    }
    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }
}
