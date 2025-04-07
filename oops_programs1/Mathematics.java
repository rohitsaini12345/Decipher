//inheritance program

import java.util.Scanner;

class Subject {
   int z;

   public void addition(int x, int y) {
      z = x + y;
      System.out.println("sum:" + z);
   }

   public void Subtraction(int x, int y) {
      z = x - y;
      System.out.println("difference:" + z);
   }
}

public class Mathematics extends Subject {
   public void multiplication(int x, int y) {
      z = x * y;
      System.out.println("product:" + z);
   }

   public static void main(String args[]) {
      System.out.println("Enter value of a and b:");
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      int b = sc.nextInt();

      Mathematics demo = new Mathematics();
      demo.addition(a, b);
      demo.Subtraction(a, b);
      demo.multiplication(a, b);
      sc.close();
   }
}