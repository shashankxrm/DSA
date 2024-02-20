import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class LearnArrayList2 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.add(4); // Adds 4 at the last to the list.
        System.out.println(list);
        list.add(1, 50); // To add element at a particular index.
        System.out.println(list);

        System.out.println("--------------");

        List<Integer> newList = new ArrayList<>(); // Creating a new list
        newList.add(150);
        newList.add(160);
        newList.set(0, 140); // This will change the element.
        System.out.println(newList);
        System.out.println(newList.contains(150)); // Checks whether a element is present in the list.

        list.addAll(newList);
        list.remove(1); //This will remove element at that index.
        list.remove(Integer.valueOf(150)); // This will remove the datatype value frm list.
        list.clear(); // Clears all elements frm list.
        System.out.println(list);


    }
}
