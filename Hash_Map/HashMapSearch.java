import java.util.HashMap;

public class HashMapSearch {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<>();
        capitalCities.put("USA", "Washington D.C.");
        capitalCities.put("France", "Paris");
        capitalCities.put("Germany", "Berlin");

        String keyToSearch = "France";
        if (capitalCities.containsKey(keyToSearch)) {
            System.out.println(keyToSearch + " => " + capitalCities.get(keyToSearch));
        } else {
            System.out.println(keyToSearch + " not found.");
        }
    }
}
