package Strings;

// LC 151 : Reverse Words in a String
// Given an input string s, reverse the order of the words.
// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only
// have a single space separating the words. Do not include any extra spaces.
// Example 1:
// Input: s = "the sky is blue"
// Output: "blue is sky the"

public class reverseWordsInAString {
    public String reverseWords(String s) { // O(n) O(n)
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }

    // constant space
    public String reverseWords2(String s) { // O(n) O(1)
        s = s.trim();
        char[] arr = s.toCharArray();
        int n = arr.length;
        reverse(arr, 0, n - 1);
        reverseWords(arr, n);
        return cleanSpaces(arr, n);
    }

    private void reverse(char[] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    private void reverseWords(char[] arr, int n){
        int i = 0, j = 0;
        while(i < n){
            while(i < j || i < n && arr[i] == ' '){
                i++;
            }
            while(j < i || j < n && arr[j] != ' '){
                j++;
            }
            reverse(arr, i, j - 1);
        }
    }

    private String cleanSpaces(char[] arr, int n){
        int i = 0, j = 0;
        while(j < n){
            while(j < n && arr[j] == ' '){
                j++;
            }
            while(j < n && arr[j] != ' '){
                arr[i++] = arr[j++];
            }
            while(j < n && arr[j] == ' '){
                j++;
            }
            if(j < n){
                arr[i++] = ' ';
            }
        }
        return new String(arr).substring(0, i);
    }
}
