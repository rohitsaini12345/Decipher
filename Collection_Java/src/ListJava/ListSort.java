package ListJava;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        Collections.sort(fruits);
        System.out.println("Fruites: "+ fruits);
    }
}
