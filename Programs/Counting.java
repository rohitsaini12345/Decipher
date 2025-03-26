
/*
 Write a program to print a counting.
 */
import java.util.Scanner;

public class Counting {
  public static void main(String args[]) {
    int i = 1;
    int n;
    System.out.println("Enter a value of n:");
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    while (i <= n) {
      System.out.println(i);
      i++;
    }
    s.close();
  }
}
