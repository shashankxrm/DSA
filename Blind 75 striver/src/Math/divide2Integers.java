package Math;

// LC 29 : Divide Two Integers
// Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
// Return the quotient after dividing dividend by divisor.
// The integer division should truncate toward zero, which means losing its fractional part.
// For example, truncating -11.5 should result in -11.
// Example 1:
// Input: dividend = 10, divisor = 3
// Output: 3
// Explanation: 10/3 = truncate(3.33333..) = 3.
// Example 2:
// Input: dividend = 7, divisor = -3
// Output: -2
// Explanation: 7/-3 = truncate(-2.33333..) = -2.

public class divide2Integers {
    public int divide(int dividend, int divisor) { // O(log n) O(1)
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;
        while(dvd >= dvs){
            long temp = dvs, multiple = 1;
            while(dvd >= (temp << 1)){
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            result += multiple;
        }
        return sign == 1 ? result : -result;
    }
}
