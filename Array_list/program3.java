import java.util.ArrayList;
import java.util.Scanner;

public class program3 {
    public static void main(String[] args) {
        System.out.println("Enter a value of n:");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> starpattern = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n - i; j++) {
                row.append(" ");
            }
            for (int j = 0; j < i; j++) {
                row.append("*");
            }
            starpattern.add(row.toString());
        }

        for (String row : starpattern) {
            System.out.println(row);
        }
        sc.close();
    }
}
