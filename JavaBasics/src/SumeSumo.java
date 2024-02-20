import java.util.Scanner;

public class SumeSumo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sume = 0;
        int sumo = 0;
        while (n > 0){
            int rem = n % 10;
            if (rem % 2 == 0){
                sume = sume + rem;
            } else if (rem % 2 != 0) {
                sumo = sumo + rem;
            }
            n = n / 10;
        }
        System.out.println(sume + " "+ sumo);

    }
}
