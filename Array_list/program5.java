import java.util.ArrayList;
import java.util.Scanner;

public class program5 {
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
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1 || i == n || j == n)
                    row.append("*");
                else
                    row.append(" ");

            }
            starpattern.add(row.toString());
        }

        for (String row : starpattern) {
            System.out.println(row);
        }
        sc.close();
    }
}
