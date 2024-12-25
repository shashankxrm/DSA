package arrays;

// LC 50 : Pow(x, n)
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
// Example 1:
// Input: x = 2.00000, n = 10
// Output: 1024.00000
// Example 2:
// Input: x = 2.10000, n = 3
// Output: 9.26100

public class powerxn {
    public double myPow(double x, int n) { // O(logn) time and O(1) space
        if (n == 0) return 1.0;
        if (n == 1) return x;
        long N = n;

        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double ans = 1.0;
        while(N > 0){
            if(N % 2 == 1){
                ans = ans * x;
            }
            x = x * x;
            N = N/2;
        }
        return ans;


    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        powerxn obj = new powerxn();
        System.out.println(obj.myPow(x, n));
    }
}
