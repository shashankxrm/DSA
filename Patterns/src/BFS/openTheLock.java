package BFS;
import java.util.*;
// LC752: Open the Lock
// You have a lock in front of you with 4 circular wheels, each wheel has 10 slots: '0', '1', '2', ..., '9'. The wheels
// can rotate freely and wrap around. You have a list of deadends, which means if the lock displays any of these
// configurations, the wheels of the lock will stop turning and you cannot open it. Given a target representing the
// value of the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
// Example 1: Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202" Output: 6
// Example 2: Input: deadends = ["8888"], target = "0009" Output: 1
public class openTheLock {
    public int openLock(String[] deadends, String target) { // Time: O(1), Space: O(1)
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000") || deadSet.contains(target)) return -1; // Cannot start or reach target
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int turns = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return turns; // Found the target
                for (int j = 0; j < 4; j++) {
                    for (int d = -1; d <= 1; d += 2) { // Rotate up or down
                        char[] nextState = current.toCharArray();
                        nextState[j] = (char) ((nextState[j] - '0' + d + 10) % 10 + '0');
                        String next = new String(nextState);
                        if (!deadSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            turns++;
        }
        return -1; // Target not reachable
    }
    // Bi-directional BFS approach
    public int openLockBiDirectional(String[] deadends, String target) { // Time: O(1), Space: O(1)
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000") || deadSet.contains(target)) return -1; // Cannot start or reach target
        Set<String> beginSet = new HashSet<>(); Set<String> endSet = new HashSet<>();
        beginSet.add("0000"); endSet.add(target);
        int turns = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet; beginSet = endSet; endSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String current : beginSet) {
                for (int j = 0; j < 4; j++) {
                    for (int d = -1; d <= 1; d += 2) { // Rotate up or down
                        char[] nextState = current.toCharArray();
                        nextState[j] = (char) ((nextState[j] - '0' + d + 10) % 10 + '0');
                        String next = new String(nextState);
                        if (endSet.contains(next)) return turns + 1; // Found the target
                        if (!deadSet.contains(next)) {
                            nextLevel.add(next);
                        }
                    }
                }
            }
            beginSet = nextLevel; // Move to the next level
            turns++;
        }
        return -1; // Target not reachable
    }
}
