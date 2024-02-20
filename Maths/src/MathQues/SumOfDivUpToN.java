package MathQues;

public class SumOfDivUpToN {
    public static void main(String[] args) {
        System.out.println(sumOfAllDivisors(5));
    }
    //TLE!!!
    static int sumOfAllDivisors(int n){
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <=i ; j++) {
                if (i % j == 0){
                    sum = sum + j;
                }
            }
        }
        return sum;
    }
}
