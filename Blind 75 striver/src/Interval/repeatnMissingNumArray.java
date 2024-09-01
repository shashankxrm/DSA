package Interval;

// Interview Bit : Repeat and Missing Number Array
// You are given a read only array of n integers from 1 to n.
// Each integer appears exactly once except A which appears twice and B which is missing.
// Return A and B.
// Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
// Note that in your output A should precede B.
// Example:
// Input:[3 1 2 5 3]
// Output:[3, 4]
// A = 3, B = 4
// Here is the solution:
// 1. Find the sum of all numbers from 1 to n using the formula n*(n+1)/2
// 2. Find the sum of squares of all numbers from 1 to n using the formula n*(n+1)*(2n+1)/6
// 3. Iterate over the array and take the difference of each element with the actual element. Let the difference be x.
// 4. The sum of all the missing numbers is the sum of all the differences. Let the sum be y.
// 5. The sum of all the squares of the missing numbers is the sum of the squares of all the differences. Let the sum be z.
// 6. The actual sum of all numbers is the sum of all numbers + A - B
// 7. The actual sum of all squares is the sum of all squares + A^2 - B^2
// 8. We have the following equations:
// n*(n+1)/2 = sum + A - B
// n*(n+1)*(2n+1)/6 = sumOfSquares + A^2 - B^2
// y = sum + A - B
// z = sumOfSquares + A^2 - B^2
// 9. We have 4 variables and 2 equations. We can solve the equations to get the values of A and B.
// 10. We can solve the equations using the following steps:
// sum = n*(n+1)/2
// sumOfSquares = n*(n+1)*(2n+1)/6
// y = sum + A - B
// z = sumOfSquares + A^2 - B^2
// sum + A - B = y
// sumOfSquares + A^2 - B^2 = z
// sum + A - B = y
// sumOfSquares + A^2 - B^2 = z
// A - B = y - sum
// A^2 - B^2 = z - sumOfSquares
// (A - B)(A + B) = y - sum
// A + B = (y - sum)/(y - sumOfSquares)
// A - B = y - sum
// A = (A + B + A - B)/2
// A = (y + sum)/2
// B = A - y + sum
// B = (y + sum)/2 - y + sum
// B = sum - y


public class repeatnMissingNumArray {
    public int[] repeatedNumber(final int[] A) { // time : O(n), space : O(1)
        long n = A.length;
        long sum = n * (n + 1) / 2;
        long sumOfSquares = n * (n + 1) * (2 * n + 1) / 6;
        long y = 0, z = 0;
        for (int i = 0; i < n; i++) {
            y += A[i];
            z += (long) A[i] * A[i];
        }
        long aMinusB = y - sum;
        long a2MinusB2 = z - sumOfSquares;
        long aPlusB = a2MinusB2 / aMinusB;
        int a = (int) (aPlusB + aMinusB) / 2;
        int b = (int) (aPlusB - aMinusB) / 2;
        return new int[] { a, b };
    }
}
