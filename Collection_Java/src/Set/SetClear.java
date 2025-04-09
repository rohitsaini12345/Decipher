package Set;

import java.util.HashSet;
import java.util.Set;

public class SetClear {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        fruits.clear();
        System.out.println("Fruits: "+ fruits);
    }

}
