
// CN Merge two arrays into a single array: https://www.naukri.com/code360/problems/sorted-array_6613259
// Given two sorted arrays, merge them such that the elements are not repeated
// Input: arr1 = [1, 3, 5, 7], arr2 = [2, 4, 6, 8]
// Output: [1, 2, 3, 4, 5, 6, 7, 8]
// o/p should be in ascending order
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class UnionArray {
     static List< Integer > sortedArray(int []a, int []b) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int j = 0; j < b.length; j++) {
            set.add(b[j]);
        }
        List<Integer> list = new ArrayList<>();
        for(int ch : set){
            list.add(ch);
        }
         sort(list);
        return list;
    }
    static void sort(List<Integer> list){
        Collections.sort(list);
    }

    public static void main(String[] args) {
         int[] a = {1, 2, 3, 4, 6};
         int[] b = {2, 3, 5};
        System.out.println(sortedArray(a, b));
    }
}
