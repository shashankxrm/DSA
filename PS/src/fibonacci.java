
// LC 509 : https://leetcode.com/problems/fibonacci-number/
// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each
// number is the sum of the two preceding ones, starting from 0 and 1.
// F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
//Given n, calculate F(n).

public class fibonacci {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
// brute

    public int fib2(int n) {
        if(n <= 1){
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
