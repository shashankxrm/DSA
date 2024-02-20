package Part1;

public class OddEven {
    public static void main(String[] args){
        System.out.println(isOdd(70));
    }
    static boolean isOdd(int n){

        return (n & 1) == 1;
    }
}