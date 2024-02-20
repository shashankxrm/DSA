package BinarySearch;

public class nxtGrtestLetter {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        System.out.println(letter(letters, 'c'));
    }
    static char letter(char[] letters, char target) {
        int s = 0;
        int e = letters.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (target < letters[m]){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return letters[s % letters.length];
    }
}
