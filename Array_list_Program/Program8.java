
import java.util.ArrayList;
import java.util.Scanner;

public class Program8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();

        ArrayList<StringBuilder> starPatterns = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 1; j < i; j++) {
                row.append(" ");
            }

            for (int k = 0; k < 2 * (n - i) + 1; k++) {
                row.append("*");
            }

            starPatterns.add(row);
        }
        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n - i; j++) {
                row.append(" ");
            }

            for (int k = 0; k < 2 * i - 1; k++) {
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
