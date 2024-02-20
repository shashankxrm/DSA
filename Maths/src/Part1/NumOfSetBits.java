package Part1;

public class NumOfSetBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(45));
        setbits(45);
    }

    static void setbits(int n) {
////        int count = 0;
////        while (n > 0) {
////            n = n - (n & (-n));
////            count++;
////        }
////        System.out.println(count);
//    }
        int count = 0;
        while (n > 0){
            count++;
            n = n & ( n - 1);
        }
        System.out.println(count);


    }
}
