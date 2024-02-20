public class Pattern4 {
    public static void main(String[] args) {
        pattern(5);
    }
    static void pattern(int n){
        for(int row = 0; row < n ; row++){
            for (int col = 0; col < row + 1; col++){
                System.out.print((row + 1) + " ");
            }
            System.out.println();
        }
    }
}
