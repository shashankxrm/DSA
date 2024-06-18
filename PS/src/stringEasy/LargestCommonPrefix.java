package stringEasy;

// LC 14 : https://leetcode.com/problems/longest-common-prefix/
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
// ex: ["flower","flow","flight"] => "fl

public class LargestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Find the shortest string in the array
        String minStr = strs[0];
        for (String str : strs) {
            if (str.length() < minStr.length()) {
                minStr = str;
            }
        }

        // Iterate over characters of the shortest string
        for (int i = 0; i < minStr.length(); i++) {
            char currentChar = minStr.charAt(i);
            // Check if the character is present in all strings at the same index
            for (String str : strs) {
                if (str.charAt(i) != currentChar) {
                    return minStr.substring(0, i); // Return the prefix found so far
                }
            }
        }

        return minStr;
    }
}
