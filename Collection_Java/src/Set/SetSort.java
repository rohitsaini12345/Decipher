package Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetSort {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        Set<String> sort = new TreeSet<>(fruits);
        System.out.println("Sorted fruits: " + sort);

    }
}
