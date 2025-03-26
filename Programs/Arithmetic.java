import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of a and b");
        a = sc.nextInt();
        b = sc.nextInt();
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        sc.close();
    }
}