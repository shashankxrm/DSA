package Part1;

public class RangeXOR {
    public static void main(String[] args) {
        // range xor for a, b = xor(b) ^ xor(a - 1)
        int a = 0;
        int b = 52;
        int ans = xor(b) ^ xor(a - 1);
        System.out.println(ans);
        //This is only for check cos it gives TLE.
        int ans2 = 0;
        for (int i = a; i <= b; i++) {
            ans2 = ans2 ^ i;
        }
        System.out.println(ans2);
    }
    // This gives xor from 0 till a.
    static int xor(int a) {
        if (a % 4 == 0) {
            return a;
        }
        if (a % 4 == 1) {
            return 1;
        }
        if (a % 4 == 2) {
            return a + 1;
        }

        return 0; // case for a % 4 == 3
    }

}
