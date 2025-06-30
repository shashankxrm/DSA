package queue;

// LC281: Zigzag Iterator
// Implement a zigzag iterator that alternates between two iterators.
// The iterator should return elements from the first iterator until it is exhausted, then switch to the second iterator,
// and continue alternating until both iterators are exhausted.
// Example 1: Input: v1 = [1,2], v2 = [3,4,5,6] Output: [1,3,2,4,5,6]
// Example 2: Input: v1 = [1,2,3], v2 = [4,5] Output: [1,4,2,5,3]
public class zigzagIterator {
    private final java.util.Iterator<Integer> it1;
    private final java.util.Iterator<Integer> it2;
    private boolean turn; // true for first iterator, false for second
    public zigzagIterator(java.util.List<Integer> v1, java.util.List<Integer> v2) {
        this.it1 = v1.iterator();
        this.it2 = v2.iterator();
        this.turn = true; // Start with the first iterator
    }
    public Integer next() {
        if (!hasNext()) {
            return null; // No more elements to return
        }
        if (turn && it1.hasNext()) {
            turn = false; // Switch to second iterator after returning from first
            return it1.next();
        } else if (it2.hasNext()) {
            turn = true; // Switch to first iterator after returning from second
            return it2.next();
        } else if (it1.hasNext()) {
            return it1.next(); // If only first iterator has elements left
        } else {
            return it2.next(); // If only second iterator has elements left
        }
    }
    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext(); // Check if either iterator has more elements
    }
}
