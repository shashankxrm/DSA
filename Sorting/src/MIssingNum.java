import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MIssingNum {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,3,2,1};
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (!set.add(i)){
                list.add(i);
            }


        }
        Collections.sort(list);
        System.out.println(list);
    }

}
