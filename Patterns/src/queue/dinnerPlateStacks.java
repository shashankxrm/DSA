package queue;
import java.util.*;

// LC1172: Dinner Plate Stacks
// You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has
// the same maximum capacity.
// Implement the DinnerPlates class:
// - DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
// - void push(int val) Pushes the given positive integer val into the leftmost stack with a size less than capacity.
// - int pop() Returns the value at the top of the rightmost stack and removes it from that stack. If there are no
// stacks with a size greater than 0, return -1.
// - int popAtStack(int index) Returns the value at the top of the stack with the given index and removes it from that
// stack. If the stack with the given index is empty, return -1.
public class dinnerPlateStacks {
    List<Stack<Integer>> list;
    int capacity;
    PriorityQueue<Integer> in;
    PriorityQueue<Integer> out;
    public dinnerPlateStacks(int capacity) {
        this.list = new ArrayList();
        this.capacity = capacity;
        this.in = new PriorityQueue();
        this.out = new PriorityQueue<Integer>((a, b) -> b - a);
    }
    public void push(int val) {
        if (list.size() == 0)
            list.add(new Stack<Integer>());
        int index;
        if (in.isEmpty()) {
            int n = list.size();
            index = n - 1;
            if (list.get(index).size() == capacity)
                index++;
            if (list.size() <= index)
                list.add(new Stack<Integer>());
            list.get(index).push(val);
        } else {
            index = in.poll();
            list.get(index).push(val);
        }
        out.add(index);
    }
    public int pop() {
        int n = list.size();
        if (n == 0)
            return -1;
        int index;
        while (!out.isEmpty()) {
            index = out.poll();
            if (list.size() <= index || list.get(index).isEmpty()) {
                continue;
            } else {
                in.add(index);
                return list.get(index).pop();
            }
        }
        return -1;
    }
    public int popAtStack(int index) {
        if (index >= list.size() || list.get(index).isEmpty())
            return -1;
        int popped = list.get(index).pop();
        in.add(index);
        return popped;
    }
}
