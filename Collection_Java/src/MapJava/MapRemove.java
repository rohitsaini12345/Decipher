package MapJava;

import java.util.HashMap;
import java.util.Map;

public class MapRemove {
    public static void main(String[] args) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(2, "Rohit");
        mp.put(4, "Aakash");
        mp.put(3, "Mohit");
        mp.put(1, "Naksh");
        mp.put(5, "Vipul");

        System.out.println("before removal: "+ mp);
        mp.remove(3);
        System.out.println("after removal: "+ mp);
    }
}
