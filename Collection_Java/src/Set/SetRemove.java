package Set;

import java.util.HashSet;
import java.util.Set;

public class SetRemove {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        System.out.println("Before removal: " + fruits);
        fruits.remove("Orange");
        System.out.println("After removal: "+ fruits);

    }
}
