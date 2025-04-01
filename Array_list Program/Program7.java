
import java.util.ArrayList;
import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();

        ArrayList<StringBuilder> starPatterns = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 1; j <= n - i; j++) {
                row.append(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                row.append("*");
            }

            starPatterns.add(row);
        }
        for (int i = n - 1; i >= 1; i--) {
            StringBuilder row = new StringBuilder();

            for (int j = 1; j <= n - i; j++) {
                row.append(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                row.append("*");
            }
            starPatterns.add(row);
        }

        for (StringBuilder row : starPatterns) {
            System.out.println(row);
        }
        sc.close();
    }
}
