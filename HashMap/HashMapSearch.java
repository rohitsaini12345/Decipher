import java.util.HashMap;

public class HashMapSearch {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("IN", "India");
        map.put("US", "United States");
        map.put("JP", "Japan");

        String key = "IN";
        if (map.containsKey(key)) {
            System.out.println("Key found: " + key + " -> " + map.get(key));
        }

        if (map.containsValue("Japan")) {
            System.out.println("Value found: Japan");
        }
    }
}
