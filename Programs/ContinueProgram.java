import java.util.Scanner;

public class ContinueProgram {
  public static void main(String args[]) {
    int n;
    System.out.println("Enter a value of n:");
    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    for (int i = 1; i <= n; i++) {
      if (i == 5)
        continue;
      System.out.println(i);
    }
    s.close();
  }
}