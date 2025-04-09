package Set;

import java.util.HashSet;
import java.util.Set;

public class SetRead {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        for (String fruit:fruits){
            System.out.println("Fruits: " + fruit);
        }
    }
}
