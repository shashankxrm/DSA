package MathQues;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println(arm(154));
    }
    static boolean arm(int n){
        int temp = n;
        String s = Integer.toString(n);
        int p = s.length();
        int ans = 0;
        while (n != 0){
            int rem = n % 10;
            ans = (int) (ans + Math.pow(rem, p));
            n = n / 10;
        }
        if (temp == ans){
            return true;
        }
        return false;
    }
}
