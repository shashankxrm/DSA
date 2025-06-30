package queue;
import java.util.*;
// LC1700: Number of Students Unable to Eat Lunch
// The school cafeteria offers circular and square sandwiches at lunch break, and all students stand in a queue.
// The sandwiches are represented by an integer array `sandwiches` where `sandwiches[i]` is the type of the ith sandwich.
// The students are represented by an integer array `students` where `students[i]` is the type of the ith student.
// Each student can only take a sandwich of their type, and they will eat it immediately.
// The sandwiches are served in the order they appear in the `sandwiches` array.
// The goal is to determine the number of students who are unable to eat their sandwich.
// Example 1: Input: sandwiches = [1,1,0,0], students = [0,1,0,1] Output: 0
// Example 2: Input: sandwiches = [1,1,1,0,0,1], students = [1,0,0,0,1,1] Output: 3
public class NumOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length; // Sandwiches will be the same length
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();
        // Add students and sandwiches to the queue and stack
        for (int i = 0; i < len; i++) {
            sandwichStack.push(sandwiches[len - i - 1]);
            studentQueue.offer(students[i]);
        }
        // Simulate the lunch process by serving sandwiches or sending students to the back of the queue.
        int lastServed = 0;
        while (studentQueue.size() > 0 && lastServed < studentQueue.size()) {
            if (sandwichStack.peek() == studentQueue.peek()) {
                sandwichStack.pop(); // Serve sandwich
                studentQueue.poll(); // Student leaves queue
                lastServed = 0;
            } else {
                // Student moves to back of queue
                studentQueue.offer(studentQueue.poll());
                lastServed++;
            }
        }
        // Remaining students in queue are unserved students
        return studentQueue.size();
    }
}
