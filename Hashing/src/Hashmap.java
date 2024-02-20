
import java.util.*;
public class Hashmap {
    public static void main(String[] args) {
        // Country (Key) Population (Value)
        HashMap <String, Integer> map = new HashMap<>();
        // Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);
        System.out.println(map);
        map.put("India", 140);
        System.out.println(map);

        // Search
        System.out.println(map.containsKey("India"));
        System.out.println(map.get("India"));
        System.out.println(map.get("Indonesia"));

        // Iteration
        // Map.Entry<Integer, Integer> e : Map.entrySet();  --->SYNTAX
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        Set<String> keys = map.keySet();
        for (String key : keys){
            System.out.println(key + " " + map.get(key));
        }

    }
}
