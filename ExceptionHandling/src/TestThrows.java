import java.util.Scanner;

public class TestThrows {
    public static int divide(int a, int b)throws ArithmeticException {
        if (b == 0) {
            System.out.println("Division by zero is not allowed");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program starting...");
        try {
            System.out.print("Enter number 1: ");
            int n1 = sc.nextInt();
            System.out.print("Enter number 2: ");
            int n2 = sc.nextInt();

            int result = divide(n1, n2);
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Some other error occurred.");
        }
        finally {
            System.out.println("hello I am finally");
            System.out.println("I am run Everytime whenever try or catch block executed or not");
        }
        sc.close();

        System.out.println("code terminating");
    }
}
