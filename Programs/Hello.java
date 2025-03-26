
//Basic program of java
import java.util.Scanner;

public class Hello {
    public static void main(String args[]) {
        System.out.println("Type Something");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println("you entered:" + str);
        s.close();
    }
}