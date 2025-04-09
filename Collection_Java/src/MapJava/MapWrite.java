package MapJava;

import java.util.HashMap;
import java.util.Map;

public class MapWrite {
    public static void main(String[] args) {
        Map<Integer,String> mp=new HashMap<>();
        mp.put(2,"Rohit");
        mp.put(4,"Aakash");
        mp.put(3,"Mohit");
        mp.put(1,"Naksh");
        mp.put(5,"Vipul");

        System.out.println("Map: "+ mp);
    }
}
