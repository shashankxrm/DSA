package binary;

// LC 190 : Reverse Bits
// Reverse bits of a given 32 bits unsigned integer.
// Example 1:
// Input: n = 00000010100101000001111010011100
// Output:    964176192 (00111001011110000010100101000000)

public class reverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }
}
