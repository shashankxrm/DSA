package LLeasy;

// GFG: https://www.geeksforgeeks.org/problems/introduction-to-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=introduction-to-linked-list
// Given an array arr[] of size N. The task is to create a linked list from the given array.
// Example:
// Input: N = 3, arr[] = {1, 2, 3}
// Output: 1 2 3
// Explanation: The linked list is 1->2->3.
public class LLfromArray {
    // User function Template for Java


    class Node {
        int data;
        Node next;

        Node() { data = 0; }
        Node(int d) { data = d; }  //constructor to create a new node
    }


        Node constructLL(int arr[]) {
            if(arr.length == 0){
                return null;
            }
            Node head = new Node(arr[0]);
            Node temp = head;

            for(int i = 1; i < arr.length; i++){
                Node node = new Node(arr[i]);
                temp.next = node;
                temp = node;


            }
            return head;

        }
    }

