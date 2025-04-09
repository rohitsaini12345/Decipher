import java.util.Scanner;

public class TestFullThrow {
        // Method that checks for zero and throws an exception
        public static int divide(int a, int b) {
            if (b == 0) {
                //throw just throw an exception
                throw new ArithmeticException("Division by zero is not allowed.");
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
                sc.close();
                System.out.println("Program ending...");
            }
        }
    }

