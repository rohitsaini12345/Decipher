package ListJava;

import java.util.ArrayList;
import java.util.List;

public class ListRemove {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        fruits.remove(2);
        System.out.println("Fruits: " + fruits);

    }
}
