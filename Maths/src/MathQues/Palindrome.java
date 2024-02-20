package MathQues;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(121));
    }
    static boolean palindrome(int n){  // 1 <= n <= 10^9
        int temp = n;
        int rev = 0;
        while(n != 0){
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        if (rev == temp){
            return true;
        }
        return false;
    }
}

