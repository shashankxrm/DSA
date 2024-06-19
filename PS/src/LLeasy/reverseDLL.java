package LLeasy;

// GFG:  https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-doubly-linked-list

public class reverseDLL {

    public static Node reverseDLL(Node  head) {

        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while(curr != null){
            curr.prev = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
    class Node
    {
        int data;
        Node next, prev;
        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

}
