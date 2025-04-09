package MapJava;

import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;

public class MapSort {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(2, "Rohit");
        mp.put(4, "Aakash");
        mp.put(3, "Mohit");
        mp.put(1, "Naksh");
        mp.put(5, "Vipul");


        Map<Integer, String> sorted = new TreeMap<>(mp);
        System.out.println("Sorted Map: " + sorted);
    }
}
