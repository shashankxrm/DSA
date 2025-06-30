package topKelements;

// LC621: Task Scheduler
// Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
// Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete
// either one task or just be idle. However, there is a non-negative integer n that represents the cooldown period between
// two same tasks (the same letter in the array), that is, there must be at least n units of time between any two same tasks.
// Return the least number of units of times that the CPU will take to finish all the given tasks.
// Example 1: Input: tasks = ["A","A","A","B","B","B"], n = 2 Output: 8
// Example 2: Input: tasks = ["A","A","A","B","B","B"], n = 0 Output: 6
public class taskScheduler {
    public int leastInterval(char[] tasks, int n) { // Time: O(n), Space: O(1)
        int[] frequency = new int[26]; // Frequency array for tasks A-Z
        for (char task : tasks) {
            frequency[task - 'A']++; // Count frequency of each task
        }
        int maxFrequency = 0; // Maximum frequency of any task
        for (int freq : frequency) {
            maxFrequency = Math.max(maxFrequency, freq);
        }
        int maxCount = 0; // Count how many tasks have the maximum frequency
        for (int freq : frequency) {
            if (freq == maxFrequency) {
                maxCount++;
            }
        }
        // Calculate the minimum time required
        return Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + maxCount);
    }
}
