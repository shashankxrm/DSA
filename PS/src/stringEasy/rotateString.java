package stringEasy;

// LC 796 : https://leetcode.com/problems/rotate-string/
// We are given two strings, A and B.
// A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
// For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
// ex: A = 'abcde', B = 'cdeab' => true
// ex: A = 'abcde', B = 'abced' => false
// ex: A = 'abcde', B = 'abcde' => true

public class rotateString {
//    static boolean rotateString2(String s, String goal) {
//        if (s.length() != goal.length()){
//            return false;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            s = s.substring(1) + s.charAt(0);
//            if (s.equals(goal)){
//                return true;
//            }
//        }
//        return false;
//    }

//    public static void main(String[] args) {
//        String s = "abcde";
//        String goal = "abced";
//        System.out.println(rotateString(s, goal));
//    }
    public  boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()){
            return false;
        }
        return (s + s).contains(goal);
    }

}
