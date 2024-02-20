package Part2;
public class PrimeNum {
    public static void main(String[] args) {
       int n = 10;
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " " + prime(i) );
        }
    }
    static boolean prime(int n) {
        int c = 2;
        if (n <= 1){
            return false;
        }
        while(c * c <= n) {
            if (n % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }



}
