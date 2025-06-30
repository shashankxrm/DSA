package topKelements;

// LC692: Top K Frequent Words
// Given an array of strings words and an integer k, return the k most frequent strings.
// Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their
// lexicographical order. example 1: Input: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
// Output: ["i", "love"]
public class topKfreqWords {
    public java.util.List<String> topKFrequent(String[] words, int k) { // Time: O(n log k), Space: O(n)
        java.util.Map<String, Integer> frequencyMap = new java.util.HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1); // Count frequency of each word
        }
        java.util.PriorityQueue<String> minHeap = new java.util.PriorityQueue<>(
                (a, b) -> frequencyMap.get(a).equals(frequencyMap.get(b))
                        ? b.compareTo(a) // reverse lexicographical for minHeap
                        : frequencyMap.get(a) - frequencyMap.get(b)
        );
        for (java.util.Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry.getKey()); // Add to heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Maintain size of heap to k
            }
        }
        java.util.List<String> result = new java.util.ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll()); // Extract the top k frequent words
        }
        java.util.Collections.reverse(result); // Reverse to get highest frequency first
        return result; // Return the result list
    }
}
