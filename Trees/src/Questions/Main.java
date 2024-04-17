package Questions;

public class Main {
    public static void main(String[] args) {
        System.out.println(merge("abcx", "def"));

    }
    static String merge(String a, String b){
        int minLength = Math.min(a.length(), b.length());
        String ans = "";
        for (int i = 0; i < minLength; i++) {
            ans += a.charAt(i);
            ans += b.charAt(i);
        }
        ans += a.substring(minLength);
        ans += b.substring(minLength);
        return ans;
    }
}