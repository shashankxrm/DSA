public class Pattern19 {
    public static void main(String[] args) {
        pattern(5);
    }
    static void pattern(int n){
        // for the upper half of the pattern.

        // initial spaces.
        int iniS = 0;
        for(int i=0;i< n;i++){

            //for printing the stars in the row.
            for(int j=1;j<=n-i;j++){
                System.out.print("*");
            }

            //for printing the spaces in the row.
            for(int j=0;j<iniS;j++){
                System.out.print(" ");
            }

            //for printing the stars in the row.
            for(int j=1;j<=n-i;j++){
                System.out.print("*");
            }

            // The spaces increase by 2 every time we hit a new row.
            iniS+=2;

            // As soon as the letters for each iteration are printed, we move to the
            // next row and give a line break otherwise all letters
            // would get printed in 1 line.
            System.out.println();
        }

        // for lower half of the pattern

        // initial spaces.
        iniS = 2*n -2;
        for(int i=1;i<=n;i++){

            //for printing the stars in the row.
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            //for printing the spaces in the row.
            for(int j=0;j<iniS;j++){
                System.out.print(" ");
            }

            //for printing the stars in the row.
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            // The spaces decrease by 2 every time we hit a new row.
            iniS-=2;

            // As soon as the letters for each iteration are printed, we move to the
            // next row and give a line break otherwise all letters
            // would get printed in 1 line.
            System.out.println();
        }
    }
}

