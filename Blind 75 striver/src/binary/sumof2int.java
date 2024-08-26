package binary;


// LC 371 : Sum of Two Integers
// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
// Example 1:
// Input: a = 1, b = 2
// Output: 3

public class sumof2int {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(getSum(a, b));
    }

    static int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

}
