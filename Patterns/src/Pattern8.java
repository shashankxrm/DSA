public class Pattern8 {
    public static void main(String[] args) {
        pattern(5);
    }
    static void pattern(int n){
        for(int row = 0; row < n ; row++){
            for (int col = 0; col < row; col++){
                System.out.print(" ");
            }
            for(int j=0; j< 2 * n -(2 * row +1); j++){
                System.out.print("*");
            }
            for (int col = 0; col < row; col++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
