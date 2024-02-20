package MathQues;

public class CountDigits {
    public static void main(String[] args) {
        digits2(696969);
    }
   // Time Complexity o(n)
    static void digits(int n) {
        int count = 0;
        while (n > 0){
            count++;
            n = n / 10;
        }
        System.out.println(count);
    }
    //Time complexity O(1)
    static void digits2(int n){
        String num = Integer.toString(n);
        int ans = num.length();
        System.out.println(ans);
    }
    // Time complexity O(1)
    static void digits3(int n){
        int ans = (int) (Math.log10(n) + 1);
        System.out.println(ans);
    }



}
