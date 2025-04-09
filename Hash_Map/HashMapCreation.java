import java.util.HashMap;

public class HashMapCreation {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Mango");

        // Printing the map
        System.out.println("HashMap: " + map);
    }
}
