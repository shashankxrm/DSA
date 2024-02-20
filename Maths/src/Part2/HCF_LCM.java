package Part2;
public class HCF_LCM {
    public static void main(String[] args) {
        System.out.println(gcd(48, 46));
        System.out.println(lcm(48, 46));
    }
    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a , a);
    }
    static int lcm(int a, int b) {
        int lcm = (a * b)/gcd(a, b);
        return lcm;
    }

}
