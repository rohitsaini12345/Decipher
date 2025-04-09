import java.util.*;

public class SortByValue {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Math", 85);
        map.put("English", 92);
        map.put("Science", 78);

        // Convert entrySet to a list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort by value
        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
