package topKelements;

// LC1046: Last Stone Weight
// We have a collection of stones, each stone has a positive integer weight.
// Each turn, we choose the two heaviest stones and smash them together. Suppose the stones have weights x and y with x <= y.
// The result of this smash is:
// If x == y, both stones are destroyed, and the result is 0.
// If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
// At the end, there is at most one stone left. Return the weight of this stone (or 0 if there are no stones left).
// Example 1: Input: [2,7,4,1,8,1] Output: 1 Explanation: We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the weight of the last stone.
public class lastStoneWeight {
    public int lastStoneWeight(int[] stones) { // Time: O(n log n), Space: O(n)
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (first != second) {
                maxHeap.offer(first - second);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
