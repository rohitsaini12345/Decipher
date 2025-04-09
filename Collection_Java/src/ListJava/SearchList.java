package ListJava;

import java.util.ArrayList;
import java.util.List;

public class SearchList {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Grapes");
        fruits.add("Orange");
        fruits.add("Cherry");

        String search="Grapes";
        if(fruits.contains(search)){
            System.out.println(search + "fruit found");
        }
        else{
            System.out.println(search + "fruit not found");
        }


    }

}
