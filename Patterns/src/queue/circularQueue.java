package queue;

// LC622: Design Circular Queue
//Implement the MyCircularQueue class:
//MyCircularQueue(k) Initializes the object with the size of the queue to be k.
//int Front() Gets the front item from the queue. If the queue is empty, return -1.
//int Rear() Gets the last item from the queue. If the queue is empty, return -1.
//boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
//boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
//boolean isEmpty() Checks whether the circular queue is empty or not.
//boolean isFull() Checks whether the circular queue is full or not.
public class circularQueue {
    private final int[] queue; // Array to store the elements of the circular queue
    private int front; // Index of the front element
    private int rear; // Index of the rear element
    private int size; // Current size of the queue
    private final int capacity; // Maximum capacity of the queue

    public circularQueue(int k) { // Constructor to initialize the circular queue with a given capacity
        this.capacity = k;
        this.queue = new int[k];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean enQueue(int value) { // Method to insert an element into the circular queue
        if (isFull()) return false; // If the queue is full, return false
        rear = (rear + 1) % capacity; // Update rear index in a circular manner
        queue[rear] = value; // Insert the value at the rear index
        size++; // Increase the size of the queue
        return true; // Return true indicating successful insertion
    }

    public boolean deQueue() { // Method to delete an element from the circular queue
        if (isEmpty()) return false; // If the queue is empty, return false
        front = (front + 1) % capacity; // Update front index in a circular manner
        size--; // Decrease the size of the queue
        return true; // Return true indicating successful deletion
    }

    public int Front() { // Method to get the front item from the queue
        if (isEmpty()) return -1; // If the queue is empty, return -1
        return queue[front]; // Return the front element
    }

    public int Rear() { // Method to get the last item from the queue
        if (isEmpty()) return -1; // If the queue is empty, return -1
        return queue[rear]; // Return the rear element
    }

    public boolean isEmpty() { // Method to check if the circular queue is empty
        return size == 0; // Return true if size is 0, otherwise false
    }

    public boolean isFull() { // Method to check if the circular queue is full
        return size == capacity; // Return true if size equals capacity, otherwise false
    }
}
