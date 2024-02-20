package Part2;

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        factors3(20);
    }

    // Time complex = o(n)
    static void factors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i + " ");
            }
        }
    }

    // Both time and space will be o(sqrt(n))
    static void factors2(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n % i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + n / i + " ");
                }

            }
        }
    }
  // sorting the output
    static void factors3(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n % i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " );
                    list.add(n / i);

                }
            }
        }
        for (int i = list.size() - 1; i >= 0 ; i--) {
            System.out.print(list.get(i)+ " ");
        }

    }
}
