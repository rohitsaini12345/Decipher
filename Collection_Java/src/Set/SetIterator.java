package Set;
import  java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class SetIterator {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
