import java.util.Scanner;

class TernaryOperator {
  public static void main(String[] args) {
    int n1, n2, n3;
    System.out.println("Enter a 3 no:");
    Scanner sc = new Scanner(System.in);
    n1 = sc.nextInt();
    n2 = sc.nextInt();
    n3 = sc.nextInt();
    int largest = (n1 >= n2) ? ((n1 >= n3) ? n1 : n3) : ((n2 >= n3) ? n2 : n3);
    System.out.println("Largest Number: " + largest);

    sc.close();
  }
}