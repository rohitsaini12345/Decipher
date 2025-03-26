/* Pattern program

1
23
456
78910

*/

import java.util.Scanner;

public class NumberPattern {
  public static void main(String args[]) {
    int i, j, n;
    int count = 1;
    System.out.println("Enter a value of n:");
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    for (i = 1; i <= n; i++) {
      for (j = 1; j <= i; j++) {
        System.out.print(count);
        count++;
      }
      System.out.println();
    }
  }
}