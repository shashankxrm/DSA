public class Pattern11 {
    public static void main(String[] args) {
        pattern(5);
    }
    static void pattern(int n){
        int start;
        for(int i=0;i<n;i++){

            // if the row index is even then 1 is printed first
            // in that row.
            if(i%2 ==0) start = 1;

                // if odd, then the first 0 will be printed in that row.
            else start = 0;

            // We alternatively print 1's and 0's in each row by using
            // the inner for loop.
            for(int j=0;j<=i;j++){
                System.out.print(start + " ");
                start = 1-start;
            }


            // As soon as the numbers for each iteration are printed, we move to the
            // next row and give a line break otherwise all numbers
            // would get printed in 1 line.
        System.out.println();
        }
    }
}

