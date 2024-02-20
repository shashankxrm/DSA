package Basics;

public class Printing {
    public static void main(String[] args) {
        Nto1(5);
        System.out.println("-------");
        rev(5);
    }
    static void Nto1(int n){
        if (n == 0){
            return;
        }
        System.out.println(n);
        Nto1(n - 1);
    }
    static void rev(int n){
        if (n == 0){
            return;
        }
        rev(n - 1);
        System.out.println(n);

    }

}
