package Part1;

public class PowOfTwo {
    public static void main(String[] args) {
        int n = 9;
        boolean ans = (n & (n - 1)) == 0;
        System.out.println(ans);
    }
}
