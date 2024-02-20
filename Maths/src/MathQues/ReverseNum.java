package MathQues;

public class ReverseNum {
    public static void main(String[] args) {
        reverse(123);
    }
    static void reverse(int n){
        int ans = 0; int rem = 0;
        while (n > 0){
            rem = n % 10;
            ans = ans * 10 + rem;
            n = n / 10;
        }
        System.out.println(ans);
    }
}
