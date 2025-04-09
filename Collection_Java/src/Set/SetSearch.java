package Set;

import java.util.HashSet;
import java.util.Set;

public class SetSearch {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        if(fruits.contains("Cherry")){
            System.out.println(" present in fruits");
        }
        else{
            System.out.println( "not present in fruits");
        }
    }
}
