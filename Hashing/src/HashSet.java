import java.util.Iterator;

public class HashSet {
    public static void main(String[] args) {
        //creating
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        // Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // list.add(ele)
        System.out.println(set);
        // Search - Contains
        System.out.println(set.contains(1));
        // Delete
        set.remove(2);
        set.size();

        // Iterator
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        }
    }
