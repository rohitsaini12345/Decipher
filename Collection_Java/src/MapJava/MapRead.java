package MapJava;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class MapRead {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(2, "Rohit");
        mp.put(4, "Aakash");
        mp.put(3, "Mohit");
        mp.put(1, "Naksh");
        mp.put(5, "Vipul");

        for(Map.Entry<Integer,String>entry:mp.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
