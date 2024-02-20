import java.util.ArrayList;

public class LearnArrayList {
    public static void main(String[] args) {
/*        String[] studentsName = new String[30]; //declares an array of size 30.
        studentsName[0] = "shashank";
       // studentsName[1]...studentsName[28]
        studentsName[29] = "shiva";
        // new student
        studentsName[30] = "vishnu";
        // Array won't add extra 30th element as the size is only up to 0-29 which is 30 elements.
        // This is where ArrayList Comes in.*/

        ArrayList<String> studentsName = new ArrayList<>();
//        size = n
//               n + n / 2 + 1;    --> size of the new array after 10 elements
        studentsName.add("shashank");
        // creates a 10 sized array when you add ur first element.
        // then as u add 11th element it creates another array and copies this array in to the new one.
    }
}