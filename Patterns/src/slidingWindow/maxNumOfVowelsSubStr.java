package slidingWindow;

// LC1456: Maximum Number of Vowels in a Substring of Given Length
// Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
// Example 1: Input: s = "abciiidef", k = 3 Output: 3 Explanation: The substring "iii" contains 3 vowel letters.

public class maxNumOfVowelsSubStr {
    public int maxVowels(String s, int k) { // Time: O(n), Space: O(1)
        int maxVowels = 0, currentVowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }
            if (i >= k) {
                if (isVowel(s.charAt(i - k))) {
                    currentVowels--;
                }
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        return maxVowels;
    }
    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1; // Check if character is a vowel
    }
}
