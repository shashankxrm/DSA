public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("@!Geeks-for'Geeks, 123"));
    }
    static String isPalindrome(String s){
        s= s.replaceAll("[^a-zA-Z0-9]", "");
        return s;
    }
    }


