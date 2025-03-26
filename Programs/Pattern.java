/* Pattern program
*
**
***
****
*****

*/

import java.util.Scanner;

public class Pattern {
  public static void main(String args[]) {
    int i, j, n;
    System.out.println("Enter a value of n:");
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    for (i = 1; i <= n; i++) {
      for (j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}