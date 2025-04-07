import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapSorting {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Grapes", 3);
        map.put("Apple", 5);
        map.put("Mango", 2);

        // Sort by key using TreeMap
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
