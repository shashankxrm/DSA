package Part1;

public class NumOfDigits {
    public static void main(String[] args) {
        digits(10, 2);
    }
    static void digits(int n, int b){
        int ans = ((int) (Math.log(n) / Math.log(b))) + 1;
        System.out.println(ans);
    }
}
