import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapSorting {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Banana", 3);
        map.put("Apple", 5);
        map.put("Mango", 2);

        // TreeMap to sort by keys
        Map<String, Integer> sortedMap = new TreeMap<>(map);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
