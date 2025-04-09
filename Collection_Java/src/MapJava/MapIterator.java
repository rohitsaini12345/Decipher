package MapJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIterator {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(2, "Rohit");
        mp.put(4, "Aakash");
        mp.put(3, "Mohit");
        mp.put(1, "Naksh");
        mp.put(5, "Vipul");

        Iterator<Map.Entry<Integer,String>> it=mp.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String> entry = it.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }
    }
}
