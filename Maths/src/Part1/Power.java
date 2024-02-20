package Part1;

public class Power {
    public static void main(String[] args) {
        power(2, 2);
    }
    static void power(int base, int power) {
        int ans = 1;
        while(power > 0) {
            if (((power & 1) == 1)) {
                ans = ans * base;
            }
            base = base * base;
            power = power >> 1;
        }
        System.out.println(ans);
    }
}
