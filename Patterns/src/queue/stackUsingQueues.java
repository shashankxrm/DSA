package queue;

// LC225: Implement Stack using Queues
public class stackUsingQueues {
    // Implement a stack using two queues
    private java.util.Queue<Integer> queue1;
    private java.util.Queue<Integer> queue2;
    public stackUsingQueues() { // Constructor initializes the two queues
        queue1 = new java.util.LinkedList<>();
        queue2 = new java.util.LinkedList<>();
    }
    public void push(int x) { // Push an element onto the stack
        queue1.offer(x); // Add the element to queue1
    }
    public int pop() { // Pop the top element from the stack
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll()); // Move all but the last element to queue2
        }
        int topElement = queue1.poll(); // The last element is the top of the stack
        java.util.Queue<Integer> temp = queue1; // Swap queues
        queue1 = queue2;
        queue2 = temp;
        return topElement; // Return the popped element
    }
    public int top() { // Get the top element without removing it
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll()); // Move all but the last element to queue2
        }
        int topElement = queue1.peek(); // Peek at the last element
        queue2.offer(queue1.poll()); // Move it to queue2 to keep it in place for next pop/top
        java.util.Queue<Integer> temp = queue1; // Swap queues
        queue1 = queue2;
        queue2 = temp;
        return topElement; // Return the top element
    }
    public boolean empty() { // Check if the stack is empty
        return queue1.isEmpty(); // If queue1 is empty, stack is empty
    }
}
