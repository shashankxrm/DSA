package MathQues;

public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(97));
    }
    static boolean isPrime(int num){
        for (int i = 2; i * i <= num ; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
