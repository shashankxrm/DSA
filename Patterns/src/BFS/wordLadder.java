package BFS;
import java.util.*;
// LC127: Word Ladder
// Given two words (beginWord and endWord), and a dictionary's word list, find the length of the shortest transformation
// sequence from beginWord to endWord, such that only one letter can be changed at a time and each transformed word
// must exist in the word list. Note that beginWord is not a transformed word.
// Example 1: Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5 Explanation: One shortest transformation sequence is "hit"->"hot"->"dot"->"dog"->"cog",which is 5 words long.
public class wordLadder {
    // Bi-directional approach  // Time: O((n/2) * m^2), Space: O(n * m)
    public int ladderLengthBiDirectional(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // If endWord is not in the list, return 0
        Set<String> beginSet = new HashSet<>(); Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int length = 1; // Start with the length of the beginWord
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue; // Skip the same character
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (endSet.contains(nextWord)) return length + 1; // Found the endWord
                        if (wordSet.contains(nextWord)) {
                            nextLevel.add(nextWord);
                            wordSet.remove(nextWord); // Remove to prevent cycles
                        }
                    }
                    chars[j] = originalChar; // Restore original character
                }
            }
            beginSet = nextLevel; // Move to the next level
            length++;
        }
        return 0; // If we exhaust the sets without finding endWord
    }

    // Unidirectional approach
    public int ladderLength(String beginWord, String endWord, List<String> wordList) { // Time: O(n * m^2), Space: O(n * m)
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // If endWord is not in the list, return 0
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1; // Start with the length of the beginWord
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) return length; // Found the endWord
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] chars = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord); // Remove to prevent cycles
                        }
                    }
                }
            }
            length++; // Increment the length for the next level
        }
        return 0; // If we exhaust the queue without finding endWord
    }
}


