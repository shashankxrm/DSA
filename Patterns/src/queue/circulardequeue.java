// LC641: Implements a circular deque (double-ended queue) with fixed capacity
package queue;
public class circulardequeue {
    int[] array;      // Array to store elements
    int front;        // Points to the front element
    int rear;         // Points to the rear element
    int size;         // Current number of elements
    int capacity;     // Maximum capacity of the deque
    // Constructor to initialize the circular deque with a given capacity
    public circulardequeue(int k) {
        array = new int[k];
        size = 0;
        capacity = k;
        front = 0;
        rear = k - 1; // Rear starts at the end for initial empty state
    }
    // Adds an item at the front of Deque. Returns true if successful.
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity; // Move front backward circularly
        array[front] = value;
        size++;
        return true;
    }
    // Adds an item at the rear of Deque. Returns true if successful.
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity; // Move rear forward circularly
        array[rear] = value;
        size++;
        return true;
    }
    // Deletes an item from the front of Deque. Returns true if successful.
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity; // Move front forward circularly
        size--;
        return true;
    }
    // Deletes an item from the rear of Deque. Returns true if successful.
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity; // Move rear backward circularly
        size--;
        return true;
    }
    // Returns the front item from the Deque. Returns -1 if empty.
    public int getFront() {
        if (isEmpty()) return -1;
        return array[front];
    }
    // Returns the last item from the Deque. Returns -1 if empty.
    public int getRear() {
        if (isEmpty()) return -1;
        return array[rear];
    }
    // Returns true if the deque is empty.
    public boolean isEmpty() {
        return size == 0;
    }
    // Returns true if the deque is full.
    public boolean isFull() {
        return size == capacity;
    }
}