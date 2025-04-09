package Set;

import java.util.Set;
import java.util.HashSet;

public class SetWrite {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        System.out.println("Fruits: " + fruits);
    }
}
