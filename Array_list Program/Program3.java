/*
    *
   **
  ***
 ****
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();

        ArrayList<StringBuilder> starPatterns = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n - i; j++) {
                row.append(" ");
            }

            for (int k = 0; k < i; k++) {
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
