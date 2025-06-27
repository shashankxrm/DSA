package slidingWindow;

// LC1100: K-Length Substring With No Repeating Characters
// Given a string s and an integer k, return the number of substrings of length k with no repeating characters.
// Example 1: Input: s = "havefunonleetcode", k = 5 Output: 6 Explanation: The substrings are "havef", "avefu", "vefun",
// "efuno", "funon", and "onlet".

public class kLengthSubStrWithNoRepeat {
    public int numKLenSubstrNoRepeats(String s, int k) { // Time: O(n), Space: O(1)
        if (k > s.length()) return 0; // If k is greater than string length, return 0
        int[] freq = new int[128]; // Frequency array for characters
        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            freq[s.charAt(right)]++;
            while (freq[s.charAt(right)] > 1) { // If character repeats, move left pointer
                freq[s.charAt(left)]--;
                left++;
            }
            if (right - left + 1 == k) { // If current window size is k, count it
                count++;
                freq[s.charAt(left)]--; // Move left pointer to prepare for next iteration
                left++;
            }
            right++;
        }
        return count; // Return the total count of valid substrings
    }
}
