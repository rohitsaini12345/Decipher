import java.util.ArrayList;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        ArrayList<Integer> starCounts = new ArrayList<>();
        int n;
        System.out.println("Enter a value of n:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // Store number of stars for each row
        for (int i = 1; i <= n; i++) {
            starCounts.add(i);
        }

        // Print the pattern using the stored star counts
        for (int count : starCounts) {
            for (int i = 0; i < count; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}