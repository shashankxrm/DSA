public class Pattern15 {
    public static void main(String[] args) {
        pattern(5);
    }
    static void pattern(int n){
        // Outer loop for the number of rows.
        for(int i=0;i<n;i++){

            // Inner loop will loop for i times and
            // print alphabets from A to A + (N-i-1).
            for(char ch = 'A'; ch<='A'+(n-i-1);ch++){
                System.out.print(ch + " ");

            }
            // As soon as the letters for each iteration are printed, we move to the
            // next row and give a line break otherwise all letters
            // would get printed in 1 line.
            System.out.println();

        }
    }
}