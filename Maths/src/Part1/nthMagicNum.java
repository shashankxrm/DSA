package Part1;

public class nthMagicNum {
    public static void main(String[] args) {
            magicNum(3);
    }
    static void magicNum(int n) {
        int base = 1;
        int ans = 0;
        while (n > 0) {
            int last = n & 1;
            base = base * 5;
            ans = ans + last * base;
            n = n >> 1;
        }
        System.out.println(ans);
    }


}
