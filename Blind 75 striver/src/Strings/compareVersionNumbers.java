package Strings;

// LC 165 : Compare Version Numbers
// Compare two version numbers version1 and version2.
// If version1 > version2 return 1; if version1 < version2 return -1; otherwise return 0.
// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
// You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number.
// The first version number revision1 is the first revision of a version string and the second version number revision2 is the second revision of the version string.
// Example 1:
// Input: version1 = "1.01", version2 = "1.001"
// Output: 0
// Explanation: Ignoring leading zeroes, both "01" and "001" represent the same number "1".
// Example 2:
// Input: version1 = "1.0", version2 = "1.0.0"
// Output: 0
// Explanation: version1 does not specify revision 2, which means it is treated as "0".
// Example 3:
// Input: version1 = "0.1", version2 = "1.1"
// Output: -1
// Explanation: version1 < version2.

public class compareVersionNumbers {
    public int compareVersion(String version1, String version2) { // O(max(n, m)) O(n + m)
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = v1.length;
        int m = v2.length;
        int i = 0;
        int j = 0;
        while(i < n || j < m){
            int num1 = i < n ? Integer.parseInt(v1[i]) : 0;
            int num2 = j < m ? Integer.parseInt(v2[j]) : 0;
            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public int compareVersion2(String version1, String version2) { // O(max(n, m)) O(1)
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int num1 = 0, num2 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i++) - '0');
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j++) - '0');
            }
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }
}
