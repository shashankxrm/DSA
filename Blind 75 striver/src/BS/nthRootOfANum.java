package BS;

// Nth root of a number
// Given two numbers x and n, find the nth root of x. In other words, find the number y such that y^n = x.
// Note: The output is a double data type and will be correct up to 5 decimal places.
// If the number is a negative number, the output will be NaN.
// Example 1:
// Input: x = 7, n = 3
// Output: 1.913
// Explanation: 1.913 to the power of 3 is 7.
// Example 2:
// Input: x = 9, n = 2
// Output: 3.000

public class nthRootOfANum {
    public double nthRoot(int x, int n) { // O(log(x) * log(x)) O(1)
        if(x < 0){
            return Double.NaN;
        }
        double low = 0;
        double high = x;
        double eps = 1e-6;
        while(high - low > eps){
            double mid = low + (high - low) / 2;
            if(Math.pow(mid, n) < x){
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
