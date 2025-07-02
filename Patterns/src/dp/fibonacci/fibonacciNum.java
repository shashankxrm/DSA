package dp.fibonacci;
// LC509: Fibonacci Number
// The Fibonacci sequence is defined as follows: F(0) = 0, F(1) = 1, and F(n) = F(n-1) + F(n-2) for n > 1.
// Given an integer n, return the nth Fibonacci number.
public class fibonacciNum {
    public int fib(int n) { // Time: O(n), Space: O(1)
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1; // F(0) and F(1)
        for (int i = 2; i <= n; i++) {
            int temp = a + b; // F(n) = F(n-1) + F(n-2)
            a = b; // Update F(n-2)
            b = temp; // Update F(n-1)
        }
        return b; // Return F(n)
    }
}
