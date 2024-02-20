public class Pattern13 {
    public static void main(String[] args) {
        pattern(5);
    }
    static void pattern(int n){
        // starting number.
        int num =1;

        // Outer loop for the number of rows.
        for(int i=1;i<=n;i++){

            // Inner loop will loop for i times and
            // print numbers increasing by 1 each time.
            for(int j=1;j<=i;j++){
                System.out.print(num + " ");
                num =num+1;
            }
            // As soon as the numbers for each iteration are printed, we move to the
            // next row and give a line break otherwise all numbers
            // would get printed in 1 line.
            System.out.println();

        }
    }
}
